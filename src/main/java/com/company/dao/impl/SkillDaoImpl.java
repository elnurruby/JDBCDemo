package com.company.dao.impl;

import com.company.bean.Country;
import com.company.bean.Skill;
import com.company.bean.User;
import dao.inter.AbstractDao;
import dao.inter.SkillDaoInter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDao implements SkillDaoInter {
    @Override
    public List<Skill> getAll() {
        List<Skill> skills = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement stmt = connection.createStatement();
            String query = "SELECT * FROM country";
            stmt.execute(query);
            ResultSet rs = stmt.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int power = rs.getInt("power");
                skills.add(new Skill(id, name, power));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return skills;
    }
}
