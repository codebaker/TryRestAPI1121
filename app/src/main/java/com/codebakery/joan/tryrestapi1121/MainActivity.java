package com.codebakery.joan.tryrestapi1121;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity{

    Button buttonSearch;
    EditText editTextCity;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonSearch = findViewById(R.id.buttonSearch);
        editTextCity = findViewById(R.id.editTextCity);
        textView = findViewById(R.id.textView);

        buttonSearch.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        OpenWeatherAPITask task = new OpenWeatherAPITask();
        String weather;
        try {
            switch (view.getId()){
                case R.id.buttonSearch:
                    weather = task.execute(editTextCity.getText().toString()).get();
                    textView.setText(weather);
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally{

        }

    }
}
