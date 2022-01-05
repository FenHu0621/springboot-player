package com.lening.utils;

/**
 * 创作时间：2021/12/27 10:05
 * 作者：张贺
 */
public class FileInfo {
    private boolean flag;
    private String msg;
    private String imgaddress;


    public String getImgaddress() {
        return imgaddress;
    }

    public void setImgaddress(String imgaddress) {
        this.imgaddress = imgaddress;
    }

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

    public FileInfo(boolean flag, String msg, String imgaddress) {
        this.flag = flag;
        this.msg = msg;
        this.imgaddress = imgaddress;
    }

    public FileInfo() {
    }


}
