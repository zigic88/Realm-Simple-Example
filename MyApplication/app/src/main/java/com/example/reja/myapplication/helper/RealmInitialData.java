package com.example.reja.myapplication.helper;

import com.example.reja.myapplication.model.Dog;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Zhuinden on 2016.08.16..
 */
public class RealmInitialData implements Realm.Transaction {
    final List<Dog> dogs = new ArrayList<>();

    public RealmInitialData() {
//        Dog dog = new Dog();
        for (int a = 0; a <= 99999; a++) {
            Dog dog = new Dog();
            dog.setName("A" + a);
            dog.setAge(a);
            dogs.add(dog);
        }
//        dog.setName("A");
//        dog.setAge(1);
//        dogs.add(dog);
//
//        dog = new Dog();
//        dog.setName("B");
//        dog.setAge(2);
//        dogs.add(dog);
//
//        dog = new Dog();
//        dog.setName("C");
//        dog.setAge(3);
//        dogs.add(dog);

    }

    @Override
    public void execute(Realm realm) {
        for (Dog b : dogs) {
            realm.insertOrUpdate(b);
        }
    }

    @Override
    public int hashCode() {
        return RealmInitialData.class.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof RealmInitialData;
    }
}
