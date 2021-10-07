package com.example.db;

public class AddressVO {
    private int id;
    private String name;
    private String tel;

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "AddressVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
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

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public AddressVO(String name, String tel) {
        this.name = name;
        this.tel = tel;
    }

    public AddressVO(int id, String name, String tel) {
        this.id = id;
        this.name = name;
        this.tel = tel;
    }
}
