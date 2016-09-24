package com.example.reja.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.reja.myapplication.helper.RealmManager;
import com.example.reja.myapplication.model.Dog;
import com.example.reja.myapplication.model.Person;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        RealmManager.initializeRealmConfig(getApplicationContext());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get realm instance
        RealmManager.incrementCount();
        realm = RealmManager.getRealm();


        if (realm != null) {
            // Build the query looking at all users:
            long startTime = System.currentTimeMillis();
            RealmQuery<Dog> query = realm.where(Dog.class);

            // Add query conditions:
//            query.equalTo("name", "A99999");
            query.lessThan("age",99999 );

            // Execute the query:
            RealmResults<Dog> result1 = query.findAll();
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            Log.d("APP", "Realm running time " + totalTime + " milliseconds");
            Log.d("APP", "Execute realm success " + result1.size());

        } else {
            Log.d("APP", "realm is null");
        }
    }

    @Override
    protected void onDestroy() {
        RealmManager.decrementCount();
        super.onDestroy();
    }
}
