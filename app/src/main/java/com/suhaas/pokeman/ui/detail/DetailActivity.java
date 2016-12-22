package com.suhaas.pokeman.ui.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.suhaas.pokeman.Constants;
import com.suhaas.pokeman.R;
import com.suhaas.pokeman.data.model.Sprites;
import com.suhaas.pokeman.data.model.list.Results;
import com.suhaas.pokeman.data.remote.ApiService;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {

    ImageView pokemanImage;
    Sprites sprites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pokemanImage = (ImageView) findViewById(R.id.pokemanImage);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String pokeman = bundle.getString("nameText");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        apiService.getUser(pokeman).enqueue(new Callback<Sprites>() {
            @Override
            public void onResponse(Call<Sprites> call, Response<Sprites> response) {
                String spritesImage = response.body().getFrontShiny();
//                Log.d("Venue Name", spritesImage);
                Glide.with(getApplicationContext())
                        .load(spritesImage)
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                android.util.Log.d("GLIDE",
                                        String.format(Locale.ROOT, "onException(%s, %s, %s, %s)", e, model, target,
                                                isFirstResource), e);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                android.util.Log.d("GLIDE",
                                        String.format(Locale.ROOT, "onResourceReady(%s, %s, %s, %s, %s)", resource, model, target,
                                                isFromMemoryCache, isFirstResource));
                                return false;
                            }
                        })
                        .skipMemoryCache(true)
                        .dontTransform()
                        .into(pokemanImage);
            }

            @Override
            public void onFailure(Call<Sprites> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });
    }
}
