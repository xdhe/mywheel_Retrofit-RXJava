package com.wheel.xiaodong.mywheel.retrofithelp;

/**
 * Created by xiaodong on 17/3/29.
 */

public class HuanpengBean<T extends ErrorBean>{
    /**
     * status : 1
     * content : {}
     */

    private String status;
    private T content;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HuanpengBean{" +
                "status='" + status + '\'' +
                ", content=" + content +
                '}';
    }
}
