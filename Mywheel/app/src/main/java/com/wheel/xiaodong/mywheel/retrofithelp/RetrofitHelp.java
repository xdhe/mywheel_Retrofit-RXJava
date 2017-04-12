package com.wheel.xiaodong.mywheel.retrofithelp;

import android.util.Log;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.google.gson.Gson;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.wheel.xiaodong.mywheel.MainActivity;

import org.reactivestreams.Publisher;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.FlowableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by xiaodong on 17/3/28.
 */

public class RetrofitHelp {
    private static final int TIMEOUT_READ = 15;
    private static OkHttpClient client;
    public static DiskLruCache sOpen;
    private CompositeDisposable mDisposable = new CompositeDisposable();
    public RetrofitHelp() {
        initDiskLruCache();
    }

    public static NetworkService RetrofitHelp() {


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        /**
         * 获取缓存
         */
        Interceptor rewriteCacheControlInterceptor = CacheUtil.rewriteCacheControlInterceptor();
//        //如果默认为 缓存数据
        client = new OkHttpClient.Builder()
                //打印日志
                .addInterceptor(interceptor)
                //设置缓存
                .addNetworkInterceptor(rewriteCacheControlInterceptor)
                .readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                //失败重连
                .retryOnConnectionFailure(true)
                .connectTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
                .build();
        //创建Retrofit
        Retrofit mRetrofit = new Retrofit.Builder()
                .client(client)
                //设置baseUrl,注意，baseUrl必须后缀"/"
                .baseUrl(NetworkService.BASEURL)
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                //Rx
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                //gson转化器
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return mRetrofit.create(NetworkService.class);
    }

    private Flowable<HuanpengBean<ErrorBean>> fetch(Class<? extends ErrorBean> aClass, Map<String, String> params) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Flowable<HuanpengBean<ErrorBean>> flowable;
        String method = (String) aClass.getDeclaredField("METHOD").get(null);
        flowable = fetch2(method, params);
        return flowable;
    }

    @SuppressWarnings("unchecked")
    public Flowable<HuanpengBean<ErrorBean>> fetch2(String method, Map<String, String> params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method fetch = RetrofitHelp().getClass().getDeclaredMethod(method, Map.class);
        return (Flowable<HuanpengBean<ErrorBean>>) fetch.invoke(RetrofitHelp(), params);
    }

    /**
     * 调用请求
     *
     * @param aClass
     * @param params
     * @param cacheTag
     * @param tag
     * @param infoView
     */
    public void loadData(Class<? extends ErrorBean> aClass, Map<String, String> params, String cacheTag, int tag, InfoView infoView) {
        dealCacheAsync(aClass, cacheTag, null, false, infoView);
        Flowable<HuanpengBean<ErrorBean>> flowable = null;
        try {
            flowable = fetch(aClass, params);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (flowable != null) {

            FlowableTransformer<HuanpengBean<ErrorBean>, ErrorBean> transformer = handleResult();
            Disposable disposable = flowable.compose(transformer).compose(RxUtil.fixScheduler()).subscribe(o -> {
                Log.e("disposable", "loadData: " + o.getCode());
                if (o.getCode() != null) {
                    infoView.onError(o);
                } else {
                    dealCacheAsync(aClass, cacheTag, o, true, infoView);
                    infoView.setData(o, tag);

                }
            }, throwable -> {
                ErrorBean errorBean = new ErrorBean("8000", "网络错误");
                errorBean.setType("2");
                infoView.onError(errorBean);
            });
//                addDisposable(disposable, tag);
        } else {
        }
    }
    /**
     * 调用请求2
     *
     * @param params
     * @param tag
     * @param infoView
     */
    public void loadData(String append, Map<String, String> params, int tag, InfoView infoView) {
        Flowable<TheatersMoive> flowable = null;
        try {
            flowable = fetchTheatersMoive(TheatersMoive.class, append, params);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        if (flowable != null) {
            FlowableTransformer<HuanpengBean<ErrorBean>, ErrorBean> transformer = handleResult();
            Disposable disposable = flowable.compose(RxUtil.fixScheduler()).subscribe(o -> {
                Log.e("TheatersMoive", "TheatersMoive: " + o.getCode());
                if (o.getCode() != null) {
                    infoView.onError(o);
                } else {
                    infoView.setData(o, tag);

                }
            }, throwable -> {
                ErrorBean errorBean = new ErrorBean("8000", "网络错误");
                errorBean.setType("2");
                infoView.onError(errorBean);
            });
//                addDisposable(disposable, tag);
        } else {
        }
    }
    private Flowable<TheatersMoive> fetchTheatersMoive(Class<TheatersMoive> aClass, String append, Map<String, String> params) throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException {
        Flowable<TheatersMoive> flowable;
        String method = (String) aClass.getDeclaredField("METHOD" + append).get(null);
        flowable = fetchTheatersMoiv(method, params);
        return flowable;
    }

    public Flowable<TheatersMoive> fetchTheatersMoiv(String method, Map<String, String> params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method fetch = RetrofitHelp().getClass().getDeclaredMethod(method,Map.class);
        return (Flowable<TheatersMoive>) fetch.invoke(RetrofitHelp(), params);
    }
    /**
     * 统一返回结果处理
     *
     * @param <T>
     * @return
     */
    public static <T extends ErrorBean> FlowableTransformer<HuanpengBean<T>, T> handleResult() {
        return new FlowableTransformer<HuanpengBean<T>, T>() {
            @Override
            public Publisher<T> apply(Flowable<HuanpengBean<T>> flowable) {
                return flowable.flatMap(new Function<HuanpengBean<T>, Publisher<T>>() {
                    @Override
                    public Publisher<T> apply(@NonNull HuanpengBean<T> tHuanpengBean) throws Exception {
                        if ("1".equals(tHuanpengBean.getStatus())) {
                            return createData(tHuanpengBean.getContent());
                        } else {
                            return createData(tHuanpengBean.getContent());
                        }
                    }
                });
            }
        };
//        return upstream -> upstream.flatMap(new Function<HuanpengBean<T>, Publisher<T>>() {
//            @Override
//            public Publisher<T> apply(HuanpengBean<T> tHuanpengBean) throws Exception {
//                Log.e("HuanpengBean", "HuanpengBean: " + tHuanpengBean.getStatus());
//                Log.e("HuanpengBean222", "HuanpengBean: " + tHuanpengBean.toString());
//                if ("1".equals(tHuanpengBean.getStatus())) {
//                    return createData(tHuanpengBean.getContent());
//                } else {
//                    return createData(tHuanpengBean.getContent());
//                }
//            }
//        });
    }

    /**
     * 生成Observable
     *
     * @param <T>
     * @return
     */
    public static <T> Flowable<T> createData(final T t) {
        return Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> flowable) {
                try {
                    flowable.onNext(t);
                    flowable.onComplete();
                } catch (Exception e) {
                    flowable.onError(e);
                }
            }
        }, BackpressureStrategy.BUFFER);

    }
    /**
     * 异步处理缓存
     */
    private void dealCacheAsync(Class<? extends ErrorBean> aClass, String cacheTag, ErrorBean o, boolean isNetwork, InfoView infoView) {
        mDisposable.add(Flowable.create((FlowableOnSubscribe<ErrorBean>) sub -> {
            ErrorBean obj = o;
            try {
                obj = dealCache(aClass, cacheTag, o);
            } catch (IOException e) {
            } catch (IllegalAccessException | NoSuchFieldException e) {
            } catch (NoSuchAlgorithmException e) {
            } catch (Exception e) {
            }
            if (obj != null) {
                sub.onNext(obj);
            }
        }, BackpressureStrategy.BUFFER).compose(RxUtil.fixScheduler()).subscribe(errorBean -> {
            if (errorBean != null&&!isNetwork) {
                infoView.setData(errorBean,2);
            }
        }));
    }
    /**
     * 初始化硬盘缓存类
     */
    private static void initDiskLruCache() {
        try {
            sOpen = DiskLruCache.open(new File(MainActivity.CACHE_PATH), 1, 1, 1024 * 1024 * 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 缓存处理，一Bean类多用的情况下
     */
    private ErrorBean dealCache(Class<? extends ErrorBean> aClass, String cacheTag, ErrorBean o) throws NoSuchFieldException, IllegalAccessException, NoSuchAlgorithmException, IOException {
        ErrorBean at = o;
        Field field = aClass.getField("URL");
        String url = (String) field.get(null);
        String key;
        if (cacheTag != null) {
            key = Md5Util.getMD5(url + cacheTag);
        } else {
            key = Md5Util.getMD5(url);
        }
        DiskLruCache.Value value = sOpen.get(key);
        if (o != null) {
            String s = new Gson().toJson(o);
            if (value == null || !s.equals(value.getString(0))) {
                DiskLruCache.Editor edit = sOpen.edit(key);
                edit.set(0, s);
                edit.commit();
                at = o;
            }
        } else {
            if (value != null) {
                at = new Gson().fromJson(value.getString(0), aClass);
            }
        }
        return at;
    }


}
