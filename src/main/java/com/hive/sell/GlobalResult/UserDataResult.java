package com.hive.sell.GlobalResult;

import com.hive.sell.pojo.User;
import lombok.Data;

@Data
public class UserDataResult {

    private User user;

    private Object data;

    private UserDataResult(User user, Object data) {
        this.user = user;
        this.data = data;
    }

    public static UserDataResult build(User user, Object data) {
        return new UserDataResult(user, data);
    }
}
