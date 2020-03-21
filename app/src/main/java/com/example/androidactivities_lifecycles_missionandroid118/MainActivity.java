package com.example.androidactivities_lifecycles_missionandroid118;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText enterName;
    private EditText enterCity;
    private EditText enterAge;
    private Button sendButton;
    private final int REQUEST_CODE = 2000;

    private TextView commentIs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("LifeCycle", "onCreate: ");

        enterName = findViewById(R.id.enterName_textView);
        enterCity = findViewById(R.id.enterCity_textView);
        enterAge = findViewById(R.id.enterAge_textView);
        sendButton = findViewById(R.id.sendToA_button);
        commentIs = findViewById(R.id.commentIs_textView);

        sendButton.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LifeCycle", "onStart: ");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LifeCycle", "onPause: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LifeCycle", "onResume: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LifeCycle", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LifeCycle", "onDestroy: ");
    }

    @Override
    public void onClick(View view) {
        String name = enterName.getText().toString().trim();
        String city = enterCity.getText().toString().trim();
        int age = Integer.parseInt(String.valueOf(enterAge.getText()));

        if(!name.isEmpty()){
            Intent intent = new Intent(MainActivity.this,ActivityB.class);
            intent.putExtra("name",name);
            intent.putExtra("city",city);
            intent.putExtra("age",age);
            startActivityForResult(intent,REQUEST_CODE);
        } else{
            Toast.makeText(getApplicationContext(), "Enter your name, Thank You!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE){
            assert data != null;
            String comment = data.getStringExtra("comment");
            commentIs.setText(comment);
//            Toast.makeText(getApplicationContext(),""+comment,Toast.LENGTH_SHORT).show();
        }
    }
}
