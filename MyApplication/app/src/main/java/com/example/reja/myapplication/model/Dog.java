package com.example.reja.myapplication.model;

import io.realm.RealmObject;

/**
 * Created by reja on 9/24/16.
 */

public class Dog extends RealmObject {
    private String name;
    private int age;

    // ... Generated getters and setters ...

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}