package com.iteso.calis;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteso.calis.beans.User;

public class ActivityLogin extends AppCompatActivity {

    EditText username, password;
   // Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.activity_password);
        password = (EditText) findViewById(R.id.activity_password);

    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.activity_login:
                savePreferences();
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }




    public void savePreferences(){
        User user = new User();
        user.setName(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setLogged(true);
        SharedPreferences sharedPreferences =
                getSharedPreferences("com.iteso.session12.PREFERENCES", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("USER", user.getName());
        editor.putString("PWD", user.getPassword());
        editor.putBoolean("LOGGED", user.isLogged());
        editor.apply();
    }

}
