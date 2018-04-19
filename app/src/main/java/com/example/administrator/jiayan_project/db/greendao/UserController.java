package com.example.administrator.jiayan_project.db.greendao;

/**
 * Created by 鱼握拳 on 2018/4/18.
 */

public class UserController {
    public static volatile UserController userController;

    public static UserController getInstance() {
        if (userController == null) {
            synchronized (UserController.class) {
                if (userController == null) {
                    userController = new UserController();
                }
            }
        }
        return userController;
    }
}
