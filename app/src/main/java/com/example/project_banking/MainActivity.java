package com.example.project_banking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView welcome,usname,uscontact,usaccountNo,usCurrentBal;
    Button deposit,withdraw,logout;
    String name;
    public  static ArrayList<User>usList = new ArrayList<>();
    public static String uname = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        welcome = findViewById(R.id.welcome);
        usname = findViewById(R.id.usname);
        uscontact = findViewById(R.id.uscontact);
        usaccountNo = findViewById(R.id.usaccno);
        usCurrentBal = findViewById(R.id.uscurrbal);
        deposit = findViewById(R.id.deposit);
        withdraw = findViewById(R.id.withdraw);
        logout = findViewById(R.id.logout);



        name = LoginActivity.name;
        usList = LoginActivity.userList;
        User user = findObject(name,usList);
        welcome.setText("Welcome "+user.getName());
        usname.setText(user.getName());
        uscontact.setText(user.getContact());
        usaccountNo.setText(String.valueOf(user.getAccountNo()));
        usCurrentBal.setText(String.valueOf(user.getCurrentBalance()));
        uname = user.getUsername();

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(getBaseContext(),DepositActivity.class);
                startActivity(intent);


            }
        });

        withdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(getBaseContext(),WithdrawActivity.class);
                startActivity(intent);


            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Logout successful",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getBaseContext(),LoginActivity.class);
                startActivity(intent);


            }
        });

    }

    private User findObject(String name, ArrayList<User> usList) {
        for(User us : usList){
            if(us.getUsername().equalsIgnoreCase(name)){
                return us;
            }
        }
        return null;
    }
}