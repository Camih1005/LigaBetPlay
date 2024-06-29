package com.ligabetplay.model;

public class User extends Person{
    private String email;
    private String password;
    private String rol;

    public User(){
        super();
    }

    public User(String email, String password, String rol) {
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public User(int id, String nombre, String email, String password, String rol) {
        super(id, nombre);
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}


