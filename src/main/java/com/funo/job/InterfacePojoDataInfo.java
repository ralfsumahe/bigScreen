package com.funo.job;

import java.util.Date;

public class InterfacePojoDataInfo {
    private Date time;
    private Object value;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public InterfacePojoDataInfo() {
    }

    public InterfacePojoDataInfo(Date time, Object value) {
        this.time = time;
        this.value = value;
    }
}
