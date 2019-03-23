package com.tkm.mcabatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class StudentActivity extends Activity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        button = findViewById(R.id.button);
        String collegeName = getIntent().getStringExtra("college");
        if (collegeName != null) {
            button.setText(collegeName);
        }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbOps();
            }
        };
        button.setOnClickListener(listener);
    }

    private void intent() {
        // Create the text message with a string
        String textMessage = "TKM College";
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
        sendIntent.setType("text/plain");

// Verify that the intent will resolve to an activity
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    private void dbOps(){

        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        db.addContact(new Contact("Ravi", "9100000000"));
        db.addContact(new Contact("Srinivas", "9199999999"));
        db.addContact(new Contact("Tommy", "9522222222"));
        db.addContact(new Contact("Karthik", "9533333333"));

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
    }
}
