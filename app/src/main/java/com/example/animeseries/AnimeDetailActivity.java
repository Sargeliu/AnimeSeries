package com.example.animeseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.PrimaryKey;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AnimeDetailActivity extends AppCompatActivity {

    private static final String EXTRA_ANIME = "anime";

    private static final String TAG = "AnimeDetailActivity";
    private ImageView imageViewPoster;
    private TextView textViewTitle;
    private TextView textViewYear;
    private TextView textViewDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);
        initViews();

        Anime anime = (Anime) getIntent().getSerializableExtra(EXTRA_ANIME);
        Glide.with(this)
                .load(anime.getPoster().getUrl())
                .into(imageViewPoster);
        textViewTitle.setText(anime.getTitle());
        textViewYear.setText(String.valueOf(anime.getYear()));
        textViewDescription.setText(anime.getDescription());
    }


    private void initViews() {
        imageViewPoster = findViewById(R.id.imageViewPoster);
        textViewTitle = findViewById(R.id.textViewTitle);
        textViewYear = findViewById(R.id.textViewYear);
        textViewDescription = findViewById(R.id.textViewDescription);
    }

    public static Intent newIntent(Context context, Anime anime) {
        Intent intent = new Intent(context, AnimeDetailActivity.class);
        intent.putExtra(EXTRA_ANIME, anime);
        return intent;
    }
}