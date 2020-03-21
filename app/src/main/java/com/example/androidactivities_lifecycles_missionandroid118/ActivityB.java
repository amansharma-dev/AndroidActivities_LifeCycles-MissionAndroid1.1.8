package com.example.androidactivities_lifecycles_missionandroid118;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityB extends AppCompatActivity implements View.OnClickListener {

    private TextView receiveName;
    private TextView receiveCity;
    private TextView receiveAge;
    private TextView comment;
    private Button commentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);


        Bundle extra = getIntent().getExtras();

        receiveName = findViewById(R.id.receivedDataName_textView);
        receiveCity = findViewById(R.id.receivedDataCity_textView);
        receiveAge = findViewById(R.id.receivedDataAge_textView);
        comment = findViewById(R.id.comment_textView);
        commentButton = findViewById(R.id.commentButton);

        commentButton.setOnClickListener(this);

        if(extra!=null){
           receiveName.setText(extra.getString("name"));
            Log.d("GETVALUE", "" +extra.getString("name"));
            receiveCity.setText(extra.getString("city"));
            Log.d("GETVALUE", "" +extra.getString("city"));
            receiveAge.setText(String.valueOf(extra.getInt("age")));
            Log.d("GETVALUE", "" +String.valueOf(extra.getInt("age")));
        }

    }

    @Override
    public void onClick(View view) {
        Intent intent = getIntent();
        String getComment = comment.getText().toString().trim();
        intent.putExtra("comment",getComment);
        setResult(RESULT_OK,intent);
        finish();
    }
}
