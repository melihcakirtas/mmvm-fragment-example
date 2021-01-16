package com.example.mlakat.view;

import com.example.mlakat.model.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("/users")
    Call<List<UserModel>> getUserList();
}
