package com.spring.thymleaf.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

public class LoginData {

    @NotBlank(message = "User Name Cant be Empty.")
    @Size(min = 5, max = 12, message = "User Name must be between  8-12 char.")
    private  String userName;

//    @Email
    @Pattern(regexp = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+.[a-z]{2,4}$", message = "Invalid Email.")
    private String userEmail;
    @AssertTrue(message = "Must Agree terms and Conditions")
    private  boolean agreed;




    public LoginData() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public boolean isAgreed() {
        return agreed;
    }

    public void setAgreed(boolean agreed) {
        this.agreed = agreed;
    }

    @Override
    public String toString() {
        return "LoginData{" +
                "userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", agreed='" + agreed + '\'' +

                '}';
    }

}
