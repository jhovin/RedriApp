package com.pasantias.redriapp.repositories;

import com.orm.SugarRecord;
import com.pasantias.redriapp.models.User;

import java.util.List;

public class UserRepository {

    public static List<User> list(){
        List<User> users = SugarRecord.listAll(User.class);
        return users;
    }
    public static User read(Long id){
        User user=SugarRecord.findById(User.class,id);
        return user;
    }

    public static void save(User user){
        SugarRecord.save(user);
    }
    public static void delete(Long id){
        User user=SugarRecord.findById(User.class,id);
        SugarRecord.delete(user);

    }

}

