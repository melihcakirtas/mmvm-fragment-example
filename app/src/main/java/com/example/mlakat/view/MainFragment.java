package com.example.mlakat.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mlakat.R;
import com.example.mlakat.model.UserModel;
import com.example.mlakat.viewmodel.UserViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFragment extends Fragment {
    @BindView(R.id.animalRefreshLayout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.animallist_RecyclerView)
    RecyclerView recyclerView_user_list;

    private UserViewModel userViewModel;
    private RecylerViewAdapter recylerViewAdapter = new RecylerViewAdapter();

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        userViewModel = ViewModelProviders.of(this).get(UserViewModel.class);

        userViewModel.users.observe(getViewLifecycleOwner(), userModels -> {
            if(userModels != null){
                recyclerView_user_list.setVisibility(View.VISIBLE);
                recylerViewAdapter.updateUserList(userModels);
            }
        });

        userViewModel.MakeApiCall();

        if(recyclerView_user_list != null){
            recyclerView_user_list.setLayoutManager(new GridLayoutManager(getContext(),1));
            recyclerView_user_list.setAdapter(recylerViewAdapter);
        }

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                userViewModel.MakeApiCall();
                if(recyclerView_user_list != null){
                    recyclerView_user_list.setLayoutManager(new GridLayoutManager(getContext(),1));
                    recyclerView_user_list.setAdapter(recylerViewAdapter);
                }
            }
        });

    }
}