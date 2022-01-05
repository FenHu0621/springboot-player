package com.lening.utils;

/**
 * 创作时间：2021/12/6 14:32
 * 作者：李增强
 */
public class ResultInfo {
    private boolean flag;
    private String msg;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultInfo() {
    }

    public ResultInfo(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }
}
