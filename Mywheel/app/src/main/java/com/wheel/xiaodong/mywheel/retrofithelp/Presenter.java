package com.wheel.xiaodong.mywheel.retrofithelp;

import java.util.Map;

/**
 * Created by xiaodong on 17/3/31.
 */

public class Presenter {
    private InfoView infoView;
    private RetrofitHelp mRetrofitHelp;

    public Presenter(InfoView infoView) {
        this.infoView = infoView;
        mRetrofitHelp = new RetrofitHelp();
    }

    /**
     * 供UI调运
     *
     * @param userClass
     * @param s
     * @param map
     * @param s1
     * @param i
     */
    public void loadData(Class<User> userClass, Map<String, String> map, String s1, int i) {
        mRetrofitHelp.loadData(userClass, map, s1, i, infoView);
    }

    public void loadData(String type, Map<String, String> map, int i) {
        mRetrofitHelp.loadData(type, map, i, infoView);
    }
}
