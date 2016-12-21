package com.suhaas.pokeman.data.remote;


import com.suhaas.pokeman.data.model.list.ListResponse;
import com.suhaas.pokeman.data.model.list.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("pokemon/")
    Call<ListResponse> getListResponse();

    @GET("pokemon/{name}")
    Call<Results> getUser(@Path("name") String name);
}
