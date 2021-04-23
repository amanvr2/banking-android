package com.example.project_banking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class DepositActivity extends AppCompatActivity  {

    TextView acNo,cBal;
    EditText amount;
    String userName;
    Integer curBal;
    Button deposit,back;
    ArrayList<User> useList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);

        acNo = findViewById(R.id.acNo);
        deposit = findViewById(R.id.depositBtn);
        amount = findViewById(R.id.amount);
        cBal = findViewById(R.id.cBal);
        back = findViewById(R.id.backBtn);


        userName = MainActivity.uname;
        useList = MainActivity.usList;

        User user = findObject(userName,useList);

        acNo.setText(String.valueOf(user.getAccountNo()));

        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                int amt = Integer.parseInt(amount.getText().toString());

                for(User us:useList){
                    if(us.getUsername().equalsIgnoreCase(userName)){
                        curBal = us.getCurrentBalance();
                        curBal += amt;
                        us.setCurrentBalance(curBal);
                        cBal.setText(String.valueOf(curBal));

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