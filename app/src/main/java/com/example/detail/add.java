package com.example.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add extends AppCompatActivity {

    EditText Name;
    EditText Email;
    EditText PhoneNO;
    EditText salary;
    EditText address;
    EditText EmployeeId;
    EditText date;
    Spinner spinner;
    RadioGroup radio;
    RadioButton radioButton;

    //    EditText sex;
    Button submit;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Log.d("manish","i m here");

        Name = findViewById(R.id.add_name);
        Email = findViewById(R.id.add_email);
        PhoneNO= findViewById(R.id.add_phone);
        salary = findViewById(R.id.add_salary);
        address= findViewById(R.id.add_address);
        EmployeeId = findViewById(R.id.add_Eid);
        submit = findViewById(R.id.add_but);
        date = findViewById(R.id.add_date);
        spinner = findViewById(R.id.add_spinner);
        radio  = findViewById(R.id.radioGroup);
        Log.d("manish","i m here");


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                String name = Name.getText().toString();
                String Date = date.getText().toString();
                String email = Email.getText().toString();
                String PhoneNo = PhoneNO.getText().toString();
                String Address = address.getText().toString();
                String Salary = salary.getText().toString();
                String EmployeeID = EmployeeId.getText().toString();
                int Id = radio.getCheckedRadioButtonId();
                radioButton = findViewById(Id);
                String sex = radioButton.getText().toString();
                String compname = getIntent().getStringExtra("Keycomp");
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference();


                UserHelperClass helperClass = new UserHelperClass(name,email,PhoneNo,Address,EmployeeID,sex,Salary,Date);

                reference.child(compname).child(EmployeeID).setValue(helperClass);

                Intent intent = new Intent(add.this, list.class);
                intent.putExtra("Keycomp",compname);
                startActivity(intent);
            }
        });


    }
}