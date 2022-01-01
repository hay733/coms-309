package com.example.sumon.androidvolley;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * Java class for the Dashboard
 */
public class Dashboard extends Activity implements OnClickListener {
    private Button btnJson, btnString, btnImage, btnSignup, btnWebsocket;

    /**
     *
     * @param savedInstanceState
     * onCreate method connecting buttons to variables
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);

        btnString = (Button) findViewById(R.id.btnStringRequest);
        btnJson = (Button) findViewById(R.id.btnJsonRequest);
        btnImage = (Button) findViewById(R.id.btnImageRequest);
        btnSignup = (Button) findViewById(R.id.btnSignupRequest);
        btnWebsocket = (Button) findViewById(R.id.btnWebsocket);


        // button click listeners
        btnString.setOnClickListener(this);
        btnJson.setOnClickListener(this);
        btnImage.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnWebsocket.setOnClickListener(this);
    }

    /**
     *
     * @param v
     * method that connects all the classes to the dashboard
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnStringRequest:
                startActivity(new Intent(Dashboard.this,
                        MapActivity.class));
                break;
            case R.id.btnJsonRequest:
                startActivity(new Intent(Dashboard.this,
                        WeatherActivity.class));
                break;
            case R.id.btnImageRequest:
                startActivity(new Intent(Dashboard.this,
                        ScheduleActivity.class));
                break;
            case R.id.btnSignupRequest:
                startActivity(new Intent(Dashboard.this,
                        SignupActivity.class));
                break;
            case R.id.btnWebsocket:
                startActivity(new Intent(Dashboard.this,
                        Websocket.class));
                break;
            default:
                break;
        }
    }

}
