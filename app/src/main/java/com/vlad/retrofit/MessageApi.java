package com.vlad.retrofit;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


/**
 * Created by Vlad on 01.03.2018.
 */

public interface MessageApi {
    @GET("/api/messages")
    Single<List<Message>> messages();

    @POST("/api/messages/add")
    Call<RegistrationResponse> registerUser(@Body RegistrationBody registrationBody);

}
