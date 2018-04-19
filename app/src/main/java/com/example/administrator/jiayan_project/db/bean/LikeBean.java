package com.example.administrator.jiayan_project.db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by 鱼握拳 on 2018/4/18.
 */
@Entity
public class LikeBean {
   @Id
    private Long id;
   private String money;
   @Generated(hash = 49813453)
   public LikeBean(Long id, String money) {
       this.id = id;
       this.money = money;
   }
   @Generated(hash = 1258777425)
   public LikeBean() {
   }
   public Long getId() {
       return this.id;
   }
   public void setId(Long id) {
       this.id = id;
   }
   public String getMoney() {
       return this.money;
   }
   public void setMoney(String money) {
       this.money = money;
   }
}
