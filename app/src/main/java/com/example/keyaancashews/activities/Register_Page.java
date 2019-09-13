package com.example.keyaancashews.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.keyaancashews.R;
import com.example.keyaancashews.models.LoginResponse;
import com.example.keyaancashews.retrofit.Api;
import com.example.keyaancashews.retrofit.ApiUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Register_Page extends AppCompatActivity {

    private static final String TAG = "Register_Page";

    EditText nameText;
    EditText emailText;
    EditText passwordText;
    EditText mobileText;

    private ProgressDialog pDialog;
    Api api;
    Button signupButton;
    TextView loginLink;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        nameText = findViewById(R.id.input_name);
        emailText = findViewById(R.id.input_email);
        passwordText = findViewById(R.id.input_password);
        mobileText = findViewById(R.id.input_mobile);

        signupButton = findViewById(R.id.btn_signup);

        loginLink = findViewById(R.id.link_login);
        api = ApiUtils.getAPIService();

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the<a class="Eyqj4pXnY " style="z-index: 2147483647;" title="Click to Continue > by Advertise" href="#2293366"> registration<img src="http://cdncache-a.akamaihd.net/items/it/img/arrow-10x10.png" /></a> screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(), Login_Page.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

    }

    public void signup() {
        Log.d(TAG, "registeruser");

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String mobile = mobileText.getText().toString();
        if (validate() == false) {
            onSignupFailed();
            return;
        }

        sendPost(name, email, password, mobile);

    }

    private void sendPost(String name, String email, String password, String mobile) {

        api.registeruser(email, password, name, mobile)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        Toast.makeText(getApplicationContext(), "Registration Success fully completed! Please Login", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), Login_Page.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        Log.i(TAG, "post submitted to API." + response.body().toString());

                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "Please Enter Valid Login Details", Toast.LENGTH_LONG).show();
//                        Log.e(TAG, "Unable to submit post to API.");
                    }
                });

    }


    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Please Enter all fields", Toast.LENGTH_LONG).show();

        signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String mobile = mobileText.getText().toString();
        String TakenUsername = api.toString();

        if (name.isEmpty() || name.length() < 3) {
            nameText.setError("at least 3 characters");
            valid = false;
        } else {
            nameText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailText.setError("enter a valid email address");
            valid = false;
        } else {
            emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length() < 10) {
            mobileText.setError("enter mobile number");
            valid = false;
        } else {
            mobileText.setError(null);
        }


        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            passwordText.setError(null);
        }


        return valid;
    }
}

