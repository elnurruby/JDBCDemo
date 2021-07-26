package com.company.bean;

public class Country {
    private int id;
    private String nationality;
    private String name;

    public Country(int id, String name, String nationality) {
        this.id = id;
        this.nationality = nationality;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", country_name='" + nationality + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country() {
    }
}
