package com.example.workapp.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.example.workapp.R;
import com.example.workapp.model.Result;

public class DetailsActivity extends AppCompatActivity {
        Result result ;
        TextView selectTextView;
        ImageView selectedImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        selectTextView = findViewById(R.id.selectedText);
        selectedImageView = findViewById(R.id.selectedImage);
        Intent intent = getIntent();
        if (intent.getExtras() != null){
            result = (Result) intent.getSerializableExtra("data");
            selectTextView.setText(result.getTitle());
            GlideUrl url = new GlideUrl(result.getUrl(), new LazyHeaders.Builder()
                    .addHeader("User-Agent", "your-user-agent")
                    .build());
            Glide.with(DetailsActivity.this).load(url).into(selectedImageView);
        }
    }
}