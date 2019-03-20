package com.humu.sugartest.bean;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

import java.io.Serializable;

/**
 *  登录用户实体类，继承SugarRecord
 * Created by Administrator on 2019/3/20.
 */

public class User extends SugarRecord implements Serializable{

    @Unique //account字段是唯一键
    String account;
    String pwd;
    String name;

    /**
     * 实体类必须有默认的构造函数
     */
    public User(){

    }

    public User(String account, String pwd, String name) {
        this.account = account;
        this.pwd = pwd;
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
