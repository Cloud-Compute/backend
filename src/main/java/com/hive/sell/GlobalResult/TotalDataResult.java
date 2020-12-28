package com.hive.sell.GlobalResult;

import lombok.Data;

@Data
public class TotalDataResult {
    private double total;

    private Object data;

    private TotalDataResult(double total, Object data) {
        this.total = total;
        this.data = data;
    }

    public static TotalDataResult build(double total, Object data) {
        return new TotalDataResult(total, data);
    }
}
