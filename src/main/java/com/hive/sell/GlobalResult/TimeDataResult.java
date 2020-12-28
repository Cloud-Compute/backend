package com.hive.sell.GlobalResult;

import lombok.Data;

import java.util.Date;

@Data
public class TimeDataResult {

    private String startTime;

    private String endTime;

    private Object data;

    private TimeDataResult(String startTime, String endTime, Object data) {
        this.data = data;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static TimeDataResult build(String startTime, String endTime, Object data) {
        return new TimeDataResult(startTime, endTime, data);
    }

}
