package com.example.administrator.jiayan_project.db.greendao;

import com.example.administrator.jiayan_project.db.bean.AddressBean;
import com.example.administrator.jiayan_project.db.bean.AddressBeanDao;

import java.util.List;

/**
 * Created by 鱼握拳 on 2018/4/18.
 */

public class AddressController {

    public static volatile AddressController addressController;

    public static AddressController getInstance() {
        if (addressController == null) {
            synchronized (AddressController.class) {
                if (addressController == null) {
                    addressController = new AddressController();
                }
            }
        }
        return addressController;
    }


    /**
     * 添加数据
     */
    public long insert(AddressBean address) {
        return GreenDaoManager.getInstance().getSession().getAddressBeanDao().insert(address);
    }

    /**
     * 删除数据
     */
    public void delete(long id) {
        GreenDaoManager.getInstance().getSession().getAddressBeanDao().deleteByKey(id);
    }

    /**
     * 更新数据
     */
    public void update(AddressBean address) {
        GreenDaoManager.getInstance().getSession().getAddressBeanDao().update(address);
    }

    /**
     * 查询指定数据，条件用户名必须相同
     */
    public List<AddressBean> query(String username) {
        return GreenDaoManager.getInstance().getSession().getAddressBeanDao().queryBuilder().where(AddressBeanDao.Properties.Username.eq(username)).list();
    }

    /**
     * 更新所有的地址，取消默认
     */
    public void updateAddressWithoutDefault(String username) {
        List<AddressBean> query = query(username);
        for (AddressBean address : query) {
            address.isdefault = false;
            update(address);
        }
    }

    /**
     * 查询默认地址
     *
     * @param username
     */
    public AddressBean queryDefaultAddress(String username) {
        List<AddressBean> query = query(username);
        for (AddressBean address : query) {
            if (address.isdefault) {
                return address;
            }
        }
        return null;
    }
}
