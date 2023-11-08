package com.springboot.mongodb.repository;

public interface CustomAuthorRepo {

    void updateEmail(String email, String name, String phone);
}
