package com.xiaojiang.bean;

public class Emp {
    private String ename;
    private String egender;
    private Dep dep;

    public void setEname(String ename) {
        this.ename = ename;
    }

    public void setEgender(String egender) {
        this.egender = egender;
    }

    public void setDep(Dep dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", egender='" + egender + '\'' +
                ", dep=" + dep +
                '}';
    }

}
