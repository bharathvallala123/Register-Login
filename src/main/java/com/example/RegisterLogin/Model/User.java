package com.example.RegisterLogin.Model;
import jakarta.persistence.*;

@Entity
@Table(name = "register")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String lastname;
    private String email;
    private int phone;
    @Column (name="role")
    private String role;


    @Override
    public String toString() {
        return "User{" +

                ", firstname='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", role='" + role + '\'' +
                '}';
    }

    public User( String name, String lastname, String email, int phone, String role) {

        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.role = role;

    }
    public User() {

    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


}
