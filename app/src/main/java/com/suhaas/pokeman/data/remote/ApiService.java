package com.suhaas.pokeman.data.remote;


import com.suhaas.pokeman.data.model.ListResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("pokemon/")
    Call<ListResponse> getListResponse();
}
