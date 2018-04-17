package com.alextroy.testretro;


import com.alextroy.testretro.model.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/latest")
    Call<Currency> getCurrency(@Query("access_key") String key);
}
