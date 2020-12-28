package com.hive.sell.GlobalResult;

import lombok.Data;

@Data
public class DataResult {
    private Object data;

    private DataResult(Object data) {
        this.data = data;
    }

    public static DataResult build(Object data) {
        return new DataResult(data);
    }
}
