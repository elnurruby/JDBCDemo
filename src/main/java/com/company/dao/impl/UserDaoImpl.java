package com.company.dao.impl;

import com.company.bean.Country;
import com.company.bean.User;
import dao.inter.AbstractDao;
import dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {
    private User getUser(ResultSet rs) throws Exception {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String surname = rs.getString("surname");
        String phone = rs.getString("phone");
        String email = rs.getString("email");
        String nationality = rs.getString("nationality");
        String birthPlace = rs.getString("birthplace");
        Date birthDate = rs.getDate("birth_date");
        int nationalityID = rs.getInt("nationality_id");
        int birthplaceID = rs.getInt("birthplace_id");
        Country nationality1 = new Country(nationalityID, null, nationality);
        Country birthPlace1 = new Country(birthplaceID, birthPlace, null);
        return (new User(id, name, surname, phone, birthDate, email, nationality1, birthPlace1));
    }

    @Override
    public List<User> getAll(String name, String surname, Integer nationalityID) {
        List<User> result = new ArrayList<>();
        try (Connection c = connect()) {
            String query = "SELECT u.*, n.nationality AS nationality, c.name AS birthplace" +
                    " FROM user u LEFT JOIN country n ON u.nationality_id = n.id " +
                    "LEFT JOIN country c ON u.birthplace_id = c.id where 1=1";
            int i = 1;
            if (name != null && !name.trim().isEmpty()) {
                query += " and u.name=?";

            }
            if (surname != null && !surname.trim().isEmpty()) {
                query += " and u.surname=?";

            }
            // checking nationalityID is not empty ("")
            boolean check = String.valueOf(nationalityID).isEmpty();
            if (nationalityID != null && !check) {
                query += " and u.nationality_id=?";

            }
            PreparedStatement stmt = c.prepareStatement(query);

            if (name != null && !name.trim().isEmpty()) {
                stmt.setString(i, name);
                i++;

            }
            if (surname != null && !surname.trim().isEmpty()) {
                stmt.setString(i, surname);
                i++;

            }
            // checking nationalityID is not empty ("")
            if (nationalityID != null && !check) {
                stmt.setInt(i, nationalityID);
            }
            stmt.execute();

            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                User u = getUser(rs);
                result.add(u);
            }
        } catch (Exception exx) {
            exx.printStackTrace();
        }

        return result;
    }

    @Override
    public User getByID(int id) {
        User u = null;//
        try (Connection c = connect()) {
            String query = "SELECT u.*, n.nationality AS nationality, c.name AS birthplace" +
                    " FROM user u LEFT JOIN country n ON u.nationality_id = n.id " +
                    "LEFT JOIN country c ON u.birthplace_id = c.id where u.id = " + id;
            PreparedStatement stmt = c.prepareStatement(query);

            stmt.execute();
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                u = getUser(rs);
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
