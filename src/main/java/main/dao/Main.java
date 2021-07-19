package main.dao;

import com.company.bean.User;
import dao.inter.UserDaoInter;

public class Main {


    public static void main(String[] args)  {
        UserDaoInter userDaoInter =Context.instanceUserDAO();
        User u = new User(0,"Elnur","Abbasov","+994707777777","elnurabbasov@gmail.com");

        userDaoInter.addUser(u);
    }

}
