package com.example.workapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.workapp.R;
import com.example.workapp.model.Result;
import com.example.workapp.service.Api;
import com.example.workapp.service.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NextAct extends AppCompatActivity {
    private TextView textViewResult ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        textViewResult = findViewById(R.id.text_view_result);
        Service service = Service.getInstance();
        Call<List<Result>> call = service.getList() ;

        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                    if (!response.isSuccessful()) {
                        textViewResult.setText("Code: "+ response.code());
                        return;
                    }
                    List<Result> results = response.body();
                    for (Result res : results) {
                        String content = "\n Tittle:" +res.getTitle();
                        textViewResult.append(content);
                    }
            }
            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
}