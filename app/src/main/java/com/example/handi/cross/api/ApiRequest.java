package com.example.handi.cross.api;

import com.example.handi.cross.model.ResponseDTO;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * Created by handi.imsi on 21/08/2019.
 */

public interface ApiRequest {
    //@FormUrlEncoded
    //@GET("home")
    //Call<ResponseDTO> postItem();

    @FormUrlEncoded
    @GET("home")
    Call<ResponseDTO> postItem();

    @GET("home")
    Call<ResponseDTO> getKontak();

}
