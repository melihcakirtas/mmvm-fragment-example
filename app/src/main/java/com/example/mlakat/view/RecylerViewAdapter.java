package com.example.mlakat.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mlakat.R;
import com.example.mlakat.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RecylerViewAdapter extends RecyclerView.Adapter<RecylerViewAdapter.UserViewHolder> {
    private ArrayList<UserModel> userModelArrayList = new ArrayList<>();

    public void updateUserList(List<UserModel> newUserModel){
        userModelArrayList.clear();
        userModelArrayList.addAll(newUserModel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_recyclerview,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        TextView textName = holder.itemView.findViewById(R.id.textView_name);
        TextView textUsername = holder.itemView.findViewById(R.id.textView_age);
        TextView textViewMail = holder.itemView.findViewById(R.id.textView_email);
        TextView textViewPhone = holder.itemView.findViewById(R.id.textView_phone);
        TextView textViewWeb = holder.itemView.findViewById(R.id.textView_website);

        textName.setText(userModelArrayList.get(position).name);
        textUsername.setText(userModelArrayList.get(position).username);
        textViewMail.setText(userModelArrayList.get(position).email);
        textViewPhone.setText(userModelArrayList.get(position).phone);
        textViewWeb.setText(userModelArrayList.get(position).website);
    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
