package com.tkm.mcabatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button passDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passDataButton = findViewById(R.id.pass_data_button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passData();
            }
        };
        passDataButton.setOnClickListener(listener);
    }

    private void passData() {
        Intent intent = new Intent(getApplicationContext(), StudentActivity.class);
        intent.putExtra("college", "TKM");
        startActivity(intent);
    }
}