package main.dao;

import com.company.dao.impl.UserDaoImpl;
import dao.inter.UserDaoInter;

public class Context {
    public static UserDaoInter instanceUserDAO(){
        return new UserDaoImpl();
    }
}
