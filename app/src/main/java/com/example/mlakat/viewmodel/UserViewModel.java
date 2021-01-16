package com.example.mlakat.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mlakat.model.UserModel;
import com.example.mlakat.view.APIService;
import com.example.mlakat.view.RetrofıtInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends ViewModel {
    public MutableLiveData<List<UserModel>> users = new MutableLiveData<List<UserModel>>();

    public void MakeApiCall(){
        APIService apiService = RetrofıtInstance.getRetroClient().create(APIService.class);
        Call<List<UserModel>> call = apiService.getUserList();
        call.enqueue(new Callback<List<UserModel>>() {
            @Override
            public void onResponse(Call<List<UserModel>> call, Response<List<UserModel>> response) {
                users.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<UserModel>> call, Throwable t) {
                users.postValue(null);
                t.printStackTrace();
            }
        });
    }

    public void refresh(){
     /*   UserModel user1 = new UserModel("melih","melihcakirtas");
        UserModel user2 = new UserModel("alihan","bombaci");
        UserModel user3 = new UserModel("ahmet","seker");
        UserModel user4 = new UserModel("esra","cakirtas");

        List<UserModel> userModels = new ArrayList<>();
        userModels.add(user1);
        userModels.add(user2);
        userModels.add(user3);
        userModels.add(user4);

        users.setValue(userModels);
        */
    }

    public UserViewModel(){

    }

    public MutableLiveData<List<UserModel>> getUsers(){
        return users;
    }

}
