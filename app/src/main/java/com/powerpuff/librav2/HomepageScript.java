package com.powerpuff.librav2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomepageScript extends AppCompatActivity implements View.OnClickListener,BottomNavigationView.OnNavigationItemSelectedListener {
    Button logout;
    FirebaseAuth auth;
    FirebaseUser user;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    LibraryFragment libraryFragment = new LibraryFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    BottomNavigationView bottom_nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        auth = FirebaseAuth.getInstance();
        bottom_nav = findViewById(R.id.bottom_nav);
        bottom_nav.setOnNavigationItemSelectedListener(this);
        bottom_nav.setSelectedItemId(R.id.home);
        user = auth.getCurrentUser();

        if(user == null){
            Intent login = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(login);
            finish();
        }

    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, homeFragment).commit();
            return true;
        }

        if(item.getItemId() == R.id.search){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,searchFragment).commit();
            return true;

        }
        if(item.getItemId() == R.id.library){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,libraryFragment).commit();
            return true;

        }
        if(item.getItemId() == R.id.profile){
            getSupportFragmentManager().beginTransaction().replace(R.id.container,profileFragment).commit();
            return true;

        }
        return false;
    }
}
