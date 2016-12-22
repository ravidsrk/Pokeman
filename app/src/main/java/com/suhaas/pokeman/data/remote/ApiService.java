package com.suhaas.pokeman.data.remote;


import com.suhaas.pokeman.data.model.PokemanResponse;
import com.suhaas.pokeman.data.model.Sprites;
import com.suhaas.pokeman.data.model.Stats;
import com.suhaas.pokeman.data.model.list.ListResponse;
import com.suhaas.pokeman.data.model.list.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("pokemon/")
    Call<ListResponse> getListResponse();

    @GET("pokemon/{name}")
    Call<PokemanResponse> getPokemanResponse(@Path("name") String name);
}
