package com.spring;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Student {
    private String[] course;
    private List<String> list;
    private Map<String, String> map;
    private Set<String> set;

    public void setCourse(String[] course) {
        this.course = course;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course=" + Arrays.toString(course) +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
