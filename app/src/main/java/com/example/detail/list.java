package com.example.detail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class list extends AppCompatActivity {


    FloatingActionButton floatingActionButton;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    UserHelperClass user;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        floatingActionButton = findViewById(R.id.list_float);

        String compName = getIntent().getStringExtra("Keycomp");

        reference = FirebaseDatabase.getInstance().getReference().child(compName);

        user = new UserHelperClass();
        listView = findViewById(R.id.listview);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference();

//        list = new ArrayList<>();
//        adapter = new ArrayAdapter<String>(this, R.layout.user_info, R.id.userInfo, list);


//        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_1,list);
//        lv = (ListView) findViewById();



        list = new  ArrayList<>();
        adapter = new ArrayAdapter<String>(this,R.layout.user_info,R.id.userInfo,list);

//        String compName = getIntent().getStringExtra("keycomp");



        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(list.this, add.class);
                intent.putExtra("Keycomp", compName);
                startActivity(intent);


            }
        });


//        Log.d("manish","giyiuiuiiuih "+compName);
        ref.child(compName).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot Snapshot) {
                for (DataSnapshot ds : Snapshot.getChildren()) {

                    user = ds.getValue(UserHelperClass.class);
                    assert user != null;
                    list.add("EMPLOYEE_Id: - " + user.getEmployeeID()+" \nNAME :- "+user.getName() + " \nE-MAIL :- "+ user.getEmail()
                    + " \nADDRESS :- "+user.getAddress()+ " \nPhoneNo :- "+user.getPhoneNo()+ " \nSALARY :- "+user.getSalary()+ " \nSEX :- "+user.getSex()+ " \nJoining Date :- "+user.getDate());
                }
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });




    }
}