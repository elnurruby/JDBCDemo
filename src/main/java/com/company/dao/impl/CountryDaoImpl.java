package com.company.dao.impl;

import com.company.bean.Country;
import com.company.bean.User;
import dao.inter.AbstractDao;
import dao.inter.CountryDaoInter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDao implements CountryDaoInter {

    @Override
    public List<Country> getAllCountry() {
        List<Country> countries = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM country";
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String nationality = rs.getString("nationality");
                countries.add(new Country(id, name, nationality));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return countries;
    }
}
