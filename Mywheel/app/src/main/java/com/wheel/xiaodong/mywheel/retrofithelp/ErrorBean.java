package com.wheel.xiaodong.mywheel.retrofithelp;

/**
 * Created by xiaodong on 17/3/29.
 */

public class ErrorBean {
    public ErrorBean(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public ErrorBean() {

    }

    protected String code;
    protected String desc;
    protected String type = "1";

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
