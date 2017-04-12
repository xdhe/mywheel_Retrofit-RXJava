package com.wheel.xiaodong.mywheel.retrofithelp;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by xiaodong on 17/3/28.
 */

public interface NetworkService {

//    public static final String BASEURL = "http://dev.huanpeng.com/";
    @POST(User.URL)
    @FormUrlEncoded
    Flowable<HuanpengBean<User>> loadRepo(@FieldMap Map<String, String> params);

    public static final String BASEURL = "http://api.douban.com/";
    @POST(TheatersMoive.URL1)
    @FormUrlEncoded
    Flowable<TheatersMoive> getTheatersMoive(@FieldMap Map<String, String> params);

//    Call<User> loadRepo();

}
