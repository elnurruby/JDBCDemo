package com.company.bean;

import java.sql.Date;

public class User {
    private int id;
    private String name;
    private String surname;
    private String phone;
    private Date birthdate;
    private Country nationality;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate=" + birthdate +
                ", nationality=" + nationality +
                ", birthPlace=" + birthPlace +
                ", nationalityId=" + nationalityId +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    private Country birthPlace;
    private Integer nationalityId;

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    public Country getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(Country birthPlace) {
        this.birthPlace = birthPlace;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public User(int id, String name, String surname, String phone, Date birthdate, String email, Country nationality, Country birthPlace) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.birthPlace = birthPlace;
        this.email = email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    private String email;
}
