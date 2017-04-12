package com.wheel.xiaodong.mywheel;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.wheel.xiaodong.mywheel.databinding.ActivityMainBinding;
import com.wheel.xiaodong.mywheel.holder.CBViewHolderCreator;
import com.wheel.xiaodong.mywheel.listener.OnItemClickListener;
import com.wheel.xiaodong.mywheel.retrofithelp.ErrorBean;
import com.wheel.xiaodong.mywheel.retrofithelp.InfoView;
import com.wheel.xiaodong.mywheel.retrofithelp.Presenter;
import com.wheel.xiaodong.mywheel.retrofithelp.TheatersMoive;
import com.wheel.xiaodong.mywheel.retrofithelp.User;
import com.wheel.xiaodong.mywheel.retrofithelp.UserAdapter;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements InfoView, OnItemClickListener, SwipeRefreshLayout.OnRefreshListener {
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
    private ActivityMainBinding mBinding;
    String TAG = "MainActivity";
    private UserAdapter mAdapter;
    public static String CACHE_PATH;
    private View mHeaderView;
    private ConvenientBanner mConvenientBanner;
    private List<String> networkImages;
    private Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //缓存目录
        CACHE_PATH = this.getCacheDir().getAbsolutePath() + File.separator + "NetCache";
        mPresenter = new Presenter(this);
        Map<String, String> map = new HashMap<>();
        map.put("city", "北京");
        mPresenter.loadData("1", map, 2);
        // mPresenter.loadData(User.class, map, "main", 2);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mAdapter = new UserAdapter(this, new TheatersMoive());
        mBinding.rv.setAdapter(mAdapter);
        mBinding.rv.setLayoutManager(manager);
        mHeaderView = LayoutInflater.from(this).inflate(R.layout.adapter_transformer, mBinding.rv, false);
        mConvenientBanner = (ConvenientBanner) mHeaderView.findViewById(R.id.convenientBanner);
        mBinding.rv.addHeaderView(mHeaderView);
        mBinding.srlRefreshLayout.setColorSchemeResources(R.color.colorAccent);
        mBinding.srlRefreshLayout.setOnRefreshListener(this);

        //网络加载例子
        networkImages = Arrays.asList(images);
        mConvenientBanner.setPages(
                new CBViewHolderCreator<NetworkImageHolderView>() {
                    @Override
                    public NetworkImageHolderView createHolder() {
                        return new NetworkImageHolderView();
                    }
                }, networkImages)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
//                .setOnPageChangeListener(this)//监听翻页事件
                .setOnItemClickListener(this);
    }

    public void setData(User user) {

    }

    @Override
    public void setData(ErrorBean o, int tag) {
        if (o instanceof TheatersMoive) {
            Log.d(TAG, "setData: 6666");
            if (mBinding.srlRefreshLayout != null && mBinding.srlRefreshLayout.isRefreshing()) {
                mBinding.srlRefreshLayout.setRefreshing(false);
            }
            TheatersMoive TheatersMoive = (TheatersMoive) o;
            mAdapter.myNotifyDataSetChanged(TheatersMoive);
        }
    }

    @Override
    public void onError(ErrorBean o) {
        Log.e(TAG, "onError: " + o.toString());
        if (o.getCode().equals("2")) {
            Toast.makeText(this, o.getCode() + o.getDesc(), Toast.LENGTH_SHORT).show();
        }

    }

    // 开始自动翻页
    @Override
    protected void onResume() {
        super.onResume();
        //开始自动翻页
        if (mConvenientBanner != null) {
            mConvenientBanner.startTurning(5000);
        }
    }

    // 停止自动翻页
    @Override
    protected void onPause() {
        super.onPause();
        //停止翻页
        mConvenientBanner.stopTurning();
    }

    @Override
    public void onItemClick(int position) {
        Toast.makeText(this, "点击了第" + position + "个", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRefresh() {
        Map<String, String> map = new HashMap<>();
        map.put("city", "北京");
        mPresenter.loadData("1", map, 2);
    }
}
