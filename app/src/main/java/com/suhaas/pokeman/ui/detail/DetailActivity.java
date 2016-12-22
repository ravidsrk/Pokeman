package com.suhaas.pokeman.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.suhaas.pokeman.Constants;
import com.suhaas.pokeman.R;
import com.suhaas.pokeman.data.model.PokemanResponse;
import com.suhaas.pokeman.data.model.Sprites;
import com.suhaas.pokeman.data.model.Stats;
import com.suhaas.pokeman.data.remote.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    android.support.v7.widget.AppCompatImageView pokemanImage;

    private RecyclerView recyclerView;
    private StatsAdapter adapter;
    String pokeman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = (RecyclerView) findViewById(R.id.rvStatList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        pokemanImage = (android.support.v7.widget.AppCompatImageView) findViewById(R.id.pokemanImage);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        pokeman = bundle.getString("nameText");
        getSupportActionBar().setTitle(pokeman);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getPokemanResponse(pokeman).enqueue(new Callback<PokemanResponse>() {
            @Override
            public void onResponse(Call<PokemanResponse> call, Response<PokemanResponse> response) {
                Sprites spritesImage = response.body().getSprites();
                Glide.with(getApplicationContext())
                        .load(spritesImage.getFrontShiny())
                        .skipMemoryCache(true)
                        .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                        .dontTransform()
                        .into(pokemanImage);
            }

            @Override
            public void onFailure(Call<PokemanResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

        apiService.getPokemanResponse(pokeman).enqueue(new Callback<PokemanResponse>() {
            @Override
            public void onResponse(Call<PokemanResponse> call, Response<PokemanResponse> response) {
                for (Stats stats : response.body().getStats()){
                    Log.d("response" , stats.getStat().getName());
                    adapter = new StatsAdapter(DetailActivity.this, response.body().getStats());
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PokemanResponse> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}