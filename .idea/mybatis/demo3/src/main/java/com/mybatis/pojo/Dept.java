package com.mybatis.pojo;

import java.util.List;

public class Dept {
    private Integer did;
    private String deptName;
    /**
     * 对一对应对象，对多对应集合
     */
    private List<Emp> emps;

    @Override
    public String toString() {
        return "Dept{" +
                "did=" + did +
                ", deptName='" + deptName + '\'' +
                ", emps=" + emps +
                '}';
    }

    public Dept() {
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Dept(Integer did, String deptName) {
        this.did = did;
        this.deptName = deptName;
    }
}
