package giang.hust.qlsv.dao;

import giang.hust.qlsv.entity.User;

public class UserDao {
    public boolean checkUser(User user){
        if (user != null){
            if ("admin".equals(user.getUserName()) && "admin".equals(user.getPassword())){
                return  true;
            }
        }
        return false;
    }
}
