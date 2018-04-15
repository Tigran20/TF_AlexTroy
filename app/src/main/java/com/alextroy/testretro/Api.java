package com.alextroy.testretro;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/latest")
    Call<CurrencyExchange> getCurrency(@Query("access_key") String key);
}
