package com.example.project_banking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button login;

    public static ArrayList<User>userList = new ArrayList<>();
    public static String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fillData();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(verifyLogin(userList,username.getText().toString(),password.getText().toString())) {
                    name = username.getText().toString();
                    Toast.makeText(getBaseContext(),"Login successful",Toast.LENGTH_LONG).show();
                    Intent intent= new Intent(getBaseContext(),MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getBaseContext(),"Invalid username or password",Toast.LENGTH_LONG).show();
            }
        });
    }

    public void fillData(){
        userList.add(new User("Aman verma","amanvr2","am123", "9717411536",1234,1000));
        userList.add(new User("Simran","simvr2","sim123",  "7899171523",5678,1000));
        userList.add(new User("Arjun","arjunvr2","ar123",  "986398622",9101,1000));
        userList.add(new User("Saleem","saleemvr2","sa123",  "989876160",9873,1000));
    }

    public Boolean verifyLogin(ArrayList<User>userList,String userN,String passW){
        Log.d("user:",name);
        for(User usr:userList)
            if(usr.getUsername().equalsIgnoreCase(userN) && usr.getPassword().equals(passW))
                return true;
        return false;
    }
}