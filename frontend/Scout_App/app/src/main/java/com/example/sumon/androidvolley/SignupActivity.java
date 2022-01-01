package com.example.sumon.androidvolley;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.content.Intent;

import com.example.sumon.androidvolley.entities.User;

import java.util.regex.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Java class for signing up for an account
 *
 */
public class SignupActivity extends Activity implements OnClickListener{
    private EditText emailInput, firstName, lastName, password1, password2;
    private TextView alreadyUser, errorText;
    private Button createAccount;

    /**
     *
     * @param savedInstanceState
     * onCreate method that connects
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        //sign up (create an account) to login
        emailInput = (EditText) findViewById(R.id.emailInput);
        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        password1 = (EditText) findViewById(R.id.passwordInput);
        password2 = (EditText) findViewById(R.id.passwordInput2);
        createAccount = (Button) findViewById(R.id.btnCreateAccount);
        alreadyUser = (TextView) findViewById(R.id.alreadyUser);
        errorText = (TextView) findViewById(R.id.errorText);

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        alreadyUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
            }
        });
    }

    public void registerUser() {
        String email = emailInput.getText().toString().trim();
        String first = firstName.getText().toString().trim();
        String last = lastName.getText().toString().trim();
        String password = password1.getText().toString().trim();
        String retype_pass = password2.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            emailInput.requestFocus();
        } else if (!validEmail(email)) {
            emailInput.setError("Please put in a valid email.");
            emailInput.requestFocus();
        }

        if (first.isEmpty()) {
            firstName.setError("First name is required");
            firstName.requestFocus();
        }

        if (last.isEmpty()) {
            lastName.setError("Last name is required");
            lastName.requestFocus();
        }


        if (password.isEmpty()) {
            password1.setError("Password is required");
            password1.requestFocus();
        } else if (retype_pass.isEmpty()) {
            password2.setError("You must retype your password.");
            password2.requestFocus();
        } else if (!validPassword(password)) {
            password1.setError("Password must have at least 8 characters, 1 number, 1 capital letter and 1 lowercase letter.");
            password1.requestFocus();
        } else if (!retype_pass.equals(password)) {
            password2.setError("Passwords do not match.");
            password2.requestFocus();
        }

        int age = 18, zip = 50010;
        String city = "Ames", state = "IA";
        User user = new User(email, first, last, password, email, age, zip, city, state);
        Call<User> call = RetrofitClient
                .getInstance()
                .getAPI()
                .createUser(user);

        //TODO Debug
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                System.out.println(response.body() == null);
                if (!(response.body() == null))
                    startActivity(new Intent(SignupActivity.this, Dashboard.class));

                else {
                    emailInput.setText("There is an account already existing with this email.");
                    emailInput.requestFocus();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                System.out.println(t.getMessage());
                errorText.setText("There was a problem creating your account. Please try again.");
            }
        });
    }


    public boolean validEmail(String email){
        Pattern regex = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

        if (email.isEmpty())
            return false;
        else if (!regex.matcher(email).matches())
            return false;
        else
            return true;
    }


    public boolean validPassword(String password){
        //atleast 8 characters
        //one number, one capital letter, one lower case letter
        Pattern regex = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");

        if (password.isEmpty())
            return false;
        else if (!regex.matcher(password).matches())
            return false;
        else
            return true;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alreadyUser:
                startActivity(new Intent(SignupActivity.this,
                        LoginActivity.class));
                break;
            case R.id.btnCreateAccount:
                startActivity(new Intent(SignupActivity.this,
                        LoginActivity.class));
                break;
            default:
                break;
        }
    }
}


