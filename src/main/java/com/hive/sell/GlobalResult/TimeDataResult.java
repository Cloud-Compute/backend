package com.hive.sell.GlobalResult;

import lombok.Data;

import java.util.Date;

@Data
public class TimeDataResult {

    private Date startTime;

    private Date endTime;

    private Object data;

    private TimeDataResult(Date startTime, Date endTime, Object data) {
        this.data = data;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static TimeDataResult build(Date startTime, Date endTime, Object data) {
        return new TimeDataResult(startTime, endTime, data);
    }

}
