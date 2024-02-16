package com.example.jibc5.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;



@Entity
@Table(name = "students")
public class Student {


    @Id
    @Column(name = "Id", nullable = false)
    private Long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email")
    private String email;

    @Column(name = "Address")
    private String address;

    @Column(name = "Phone")
    private String phone;

//    @Column(name = "Image_Filename")  // Added property for image filename
//    private String imageFilename;

    public Student() {
    }

    public Student(String name, String email, String address, String phone, String imageFilename) {
        super();
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
//        this.imageFilename = imageFilename;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and setter for imageFilename
//    public String getImageFilename() {
//        return imageFilename;
//    }
//
//    public void setImageFilename(String imageFilename) {
//        this.imageFilename = imageFilename;
//    }
}
