package com.example.mobileapp_programming_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileapp_programming_project.AboutActivity;
import com.example.mobileapp_programming_project.JsonTask;
import com.example.mobileapp_programming_project.Plant;
import com.example.mobileapp_programming_project.PlantAdapter;
import com.example.mobileapp_programming_project.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity implements JsonTask.JsonTaskListener {

    private RecyclerView recyclerView;
    private PlantAdapter plantAdapter;
    private List<Plant> plantList;
    private static final String JSON_URL = "https://mobprog.webug.se/json-api?login=a22linre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        new JsonTask(this).execute(JSON_URL);

        Button btnAbout = findViewById(R.id.btnAbout);
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPostExecute(String json) {
        Type listType = new TypeToken<List<Plant>>() {}.getType();
        plantList = new Gson().fromJson(json, listType);
        plantAdapter = new PlantAdapter(plantList);
        recyclerView.setAdapter(plantAdapter);
    }
}