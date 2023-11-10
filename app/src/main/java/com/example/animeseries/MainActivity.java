package com.example.animeseries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Anime";

    private RecyclerView recyclerViewAnime;
    private ProgressBar progressBar;
    private MainViewModel viewModel;
    private AnimeAdapter animeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
        animeAdapter = new AnimeAdapter();
        recyclerViewAnime.setAdapter(animeAdapter);
        recyclerViewAnime.setLayoutManager(new GridLayoutManager(this, 2));
        viewModel.getAnime().observe(this, new Observer<List<Anime>>() {
            @Override
            public void onChanged(List<Anime> anime) {
                animeAdapter.setAnime(anime);
            }
        });
        animeAdapter.setOnReachEndListener(new AnimeAdapter.OnReachEndListener() {
            @Override
            public void onReachEnd() {
                viewModel.loadAnime();
            }
        });
        animeAdapter.setOnAnimeClickListener(new AnimeAdapter.OnAnimeClickListener() {
            @Override
            public void onAnimeClick(Anime anime) {
                Intent intent = AnimeDetailActivity.newIntent(MainActivity.this, anime);
                startActivity(intent);
            }
        });
        viewModel.getIsLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                if (isLoading) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }

    private void initViews() {
        recyclerViewAnime = findViewById(R.id.recyclerViewAnime);
        progressBar = findViewById(R.id.progressBar);
    }
}