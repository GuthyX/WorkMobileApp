package com.example.workapp.View;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;
import com.example.workapp.R;
import com.example.workapp.model.Result;
import com.example.workapp.service.Service;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private  List<Result> results = new ArrayList<>();
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);

        getImages();


    }
    public void getImages(){

        Call<List<Result>>call = Service.getInstance().getList();
        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                if (response.isSuccessful()){
                    String message = "Succes";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                    results = response.body();
                    CustomAdapter adapter = new CustomAdapter(results,MainActivity.this);
                    gridView.setAdapter(adapter);
                } else {
                    String message = "Something gone wrong! Try it Later.";
                    Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                String message = t.getLocalizedMessage();
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_LONG).show();
            }
        });
    }

}