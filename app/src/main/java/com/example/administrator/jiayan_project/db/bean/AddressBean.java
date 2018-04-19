package com.example.administrator.jiayan_project.db.bean;

import android.os.Parcel;
import android.os.Parcelable;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

/**
 * Created by 鱼握拳 on 2018/4/17.
 */
@Entity
public class AddressBean  implements Parcelable {
    @Id(autoincrement = true)
    public Long id;
    public String username;
    public String realname;
    public String phone;
    public String area;
    public String street;
    public String address;
    public boolean isdefault;
    @Generated(hash = 1051515296)
    public AddressBean(Long id, String username, String realname, String phone,
            String area, String street, String address, boolean isdefault) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.phone = phone;
        this.area = area;
        this.street = street;
        this.address = address;
        this.isdefault = isdefault;
    }
    @Generated(hash = 30780671)
    public AddressBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getRealname() {
        return this.realname;
    }
    public void setRealname(String realname) {
        this.realname = realname;
    }
    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getArea() {
        return this.area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getStreet() {
        return this.street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean getIsdefault() {
        return this.isdefault;
    }
    public void setIsdefault(boolean isdefault) {
        this.isdefault = isdefault;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.username);
        dest.writeString(this.realname);
        dest.writeString(this.phone);
        dest.writeString(this.area);
        dest.writeString(this.street);
        dest.writeString(this.address);
        dest.writeByte(this.isdefault ? (byte) 1 : (byte) 0);
    }

    protected AddressBean(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.username = in.readString();
        this.realname = in.readString();
        this.phone = in.readString();
        this.area = in.readString();
        this.street = in.readString();
        this.address = in.readString();
        this.isdefault = in.readByte() != 0;
    }

    public static final Parcelable.Creator<AddressBean> CREATOR = new Parcelable.Creator<AddressBean>() {
        @Override
        public AddressBean createFromParcel(Parcel source) {
            return new AddressBean(source);
        }

        @Override
        public AddressBean[] newArray(int size) {
            return new AddressBean[size];
        }
    };
}
