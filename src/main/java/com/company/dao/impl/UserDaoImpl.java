package com.company.dao.impl;

import com.company.bean.User;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM user");
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                result.add(new User(id, name, surname, phone, email));
            }
        } catch (Exception exx) {
            exx.printStackTrace();
        }

        return result;
    }

    @Override
    public User getByID(int id) {
        User u = null;
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            stmt.execute("SELECT * FROM user where id = " + id);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int idz = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                u = new User(idz, name, surname, phone, email);
            }
        } catch (Exception exx) {
            exx.printStackTrace();
        }
        return u;
    }

    @Override
    public boolean addUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO user (name,surname,phone,email) values(?,?,?,?)");
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getSurname());
            preparedStatement.setString(3, u.getPhone());
            preparedStatement.setString(4, u.getEmail());

            return preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateUser(User u) {
        try (Connection c = connect()) {
            PreparedStatement preparedStatement = c.prepareStatement("UPDATE user SET name =?,surname=?, phone=?, email=? WHERE id =?");
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getSurname());
            preparedStatement.setString(3, u.getPhone());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setInt(5, u.getId());
            return preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try (Connection c = connect()) {
            Statement stmt = c.createStatement();
            return stmt.execute("DELETE from user WHERE id= " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
