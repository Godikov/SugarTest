package com.humu.sugartest.utils;

import com.humu.sugartest.bean.User;

import java.util.List;

/**
 * Created by Administrator on 2019/3/20.
 */

public class UserUtils {

    /**
     * 判断传进来的用户是否在本地存在
     * User列表遍历
     * @param user
     * @return
     */
    public static boolean isExist(User user){
        boolean isExist = false;
        //判断本地数据库是否有此用户（三个值都相同）
        List<User> users = User.listAll(User.class); //找出所有User
        //User user = User.findById(User.class,1); 此方法只返回一条User。
        if(users != null && users.size() > 0){
            //本地数据库有User用户
            for(int i = 0;i<users.size();i++){
                User u = users.get(i);
                if(user.getAccount().equals(u.getAccount()) && user.getPwd().equals(u.getPwd())
                        && user.getName().equals(u.getName())){
                    //三个值都相同，代表本地存在此用户，登录成功
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

    /**
     * 判断传进来的用户是否在本地存在
     * 条件查询
     * @return
     */
    public static User isExist2(String account,String pwd,String name){
        User user = null;
        //List<User> resultUser = User.findWithQuery(User.class,"select * from User where account = ? and pwd = ? and name = ?",account,pwd,name);
        List<User> resultUser = User.find(User.class,"account=? AND pwd=? AND name=?",
                account+"",pwd+"",name+"");
        if(resultUser != null && resultUser.size() > 0){
            user = resultUser.get(0);
        }
        return user;
    }

    /**
     * 注册用户到本地
     * @return 注册结果
     */
    public static boolean registUser(String account,String pwd,String name){
        boolean registResult = false;
        User user = isExist2(account,pwd,name);
        if(user == null){
            //如果用户不在本地存在，就保存到本地
            new User(account,pwd,name).save();
            registResult = true;
        }
        return registResult;
    }

    /**
     * 删除本地指定用户信息
     */
    public static boolean unregistUser(String account,String pwd,String name){
        boolean unregistResult = false;
        User user = isExist2(account,pwd,name);
        if(user != null){
            user.delete();
            unregistResult = true;
        }
        return unregistResult;
    }

    /**
     * 重命名
     * @param name
     * @return
     */
    public static boolean rename(String account,String pwd,String name,String rename){
        boolean renameResult = false;
        User user = isExist2(account,pwd,name);
        if(user != null){
            user.setName(rename);
            user.save();
            renameResult = true;
        }
        return renameResult;
    }

}
