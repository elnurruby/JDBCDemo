package main.dao;


import dao.inter.UserDaoInter;

public class Main {


    public static void main(String[] args)  {
        UserDaoInter userDaoInter =Context.instanceUserDAO();
        System.out.println(userDaoInter.getByID(1));

    }

}
