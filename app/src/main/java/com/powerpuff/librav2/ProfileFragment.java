package com.powerpuff.librav2;



import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;


public class ProfileFragment extends Fragment implements View.OnClickListener {

    ImageView image;
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView username;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();


        if(user == null){
            Intent login = new Intent( getContext(),MainActivity.class);
            startActivity(login);
        }



    }


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        logout = view.findViewById(R.id.logout);
        logout.setOnClickListener(this);
        username = view.findViewById(R.id.username);
        username.setText(user.getEmail());
        image = view.findViewById(R.id.prof);
        String url = "https://th.bing.com/th/id/OIP.YNG-02CVzH8j0_I9qYcqhQHaHa?w=202&h=201&c=7&r=0&o=5&dpr=1.3&pid=1.7";

        Glide.with(this)
                .load(url)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(200)))
                .into(image);



        return view;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.logout ){
            FirebaseAuth.getInstance().signOut();
            Intent back = new Intent(getContext(), MainActivity.class);
            startActivity(back);
        }
    }






}