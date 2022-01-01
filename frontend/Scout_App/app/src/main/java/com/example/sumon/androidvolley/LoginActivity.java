package com.example.sumon.androidvolley;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.content.Intent;

import com.example.sumon.androidvolley.entities.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity implements OnClickListener {

    private String TAG = LoginActivity.class.getSimpleName();
    private EditText Name, Password;
    private TextView failedLogin, forgotPassword, register;
    private Button Login;
    private int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Name = (EditText) findViewById(R.id.emailInput);
        Password = (EditText) findViewById(R.id.passwordInput);
        Login = (Button) findViewById(R.id.btnLoginApp);
        failedLogin = (TextView) findViewById(R.id.failedText);
        forgotPassword = (TextView) findViewById(R.id.alreadyUser);
        register = (TextView) findViewById(R.id.needToRegister);


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });

        //need one for forgot password

    }

    protected void LoginActivity(Bundle savedState) {
        super.onCreate(savedState);
        setContentView(R.layout.login);
    }

    public void validate(){

        String userName = Name.getText().toString().trim();
        String userPassword = Password.getText().toString().trim();

        if (userName.isEmpty()) {
            Name.setError("Email is required");
            Name.requestFocus();
        } else if (userPassword.isEmpty()) {
            Password.setError("Password is required");
            Password.requestFocus();
        }

        Call<User> call = RetrofitClient
                .getInstance()
                .getAPI()
                .checkLoginCredentials(userName, userPassword);


        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (!(response.body() == null))
                    startActivity(new Intent(LoginActivity.this, Dashboard.class));

                else {
                    failedLogin.setText("Email or password is incorrect.\nPlease try again.");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getMessage());
                failedLogin.setText("Email or password is incorrect.\nPlease try again.");
            }
        });
    }

    @Override
    public void onClick(View view) {

    }
}