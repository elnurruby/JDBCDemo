package com.company.bean;

public class Skill {
    private Integer id;
    private String name;
    private Integer power;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", power=" + power +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Skill(Integer id, String name, Integer power) {
        this.id = id;
        this.name = name;
        this.power = power;
    }

    public Skill() {
    }
}
