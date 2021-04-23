package com.example.project_banking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class WithdrawActivity extends AppCompatActivity {

    TextView accountNo,curBal;
    EditText withAmount;
    Button withDraw,back;
    String userName;
    Integer currBal;
    ArrayList<User> useList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);

        accountNo = findViewById(R.id.accNo);
        curBal = findViewById(R.id.crBal);
        withAmount = findViewById(R.id.withAmount);
        withDraw = findViewById(R.id.withBtn);
        back = findViewById(R.id.back2);

        userName = MainActivity.uname;
        useList = MainActivity.usList;

        User user = findObject(userName,useList);

        accountNo.setText(String.valueOf(user.getAccountNo()));

        withDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int amt = Integer.parseInt(withAmount.getText().toString());

                for(User us:useList){
                    if(us.getUsername().equalsIgnoreCase(userName)){
                        currBal = us.getCurrentBalance();
                        currBal -= amt;
                        us.setCurrentBalance(currBal);
                        curBal.setText(String.valueOf(currBal));

                    }
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent= new Intent(getBaseContext(),MainActivity.class);
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