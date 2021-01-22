package com.xiaojiang.bean;

public class Dep {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    @Override
    public String toString() {
        return "Dep{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
