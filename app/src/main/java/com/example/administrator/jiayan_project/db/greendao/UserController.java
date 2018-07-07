package com.example.administrator.jiayan_project.db.greendao;

import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;
import com.example.administrator.jiayan_project.db.bean.KeepUserBean;
import com.example.administrator.jiayan_project.db.bean.KeepUserBeanDao;

import java.util.List;

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
    /**
     * 添加数据
     */
    public long insert(KeepUserBean address) {
        return GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().insert(address);
    }

    /**
     * 删除数据
     */
    public void delete(long id) {
        GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().deleteByKey(id);
    }

    /**
     * 更新数据
     */
    public void update(KeepUserBean address) {
        GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().update(address);
    }

    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<KeepUserBean> query(int id) {
        return GreenDaoManager.getInstance().getSession().getKeepUserBeanDao().queryBuilder().where(KeepUserBeanDao.Properties.Username.eq(id)).list();
    }
}

