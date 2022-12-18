package com.example.lostandfound;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.lostandfound.Fragments.AccountFragment;
import com.example.lostandfound.Fragments.AddItemFragment;
import com.example.lostandfound.Fragments.FoundFragment;
import com.example.lostandfound.Fragments.HomeFragment;
import com.example.lostandfound.Fragments.LostFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    LostFragment lostFragment = new LostFragment();
    AddItemFragment addItemFragment = new AddItemFragment();
    FoundFragment foundFragment = new FoundFragment();
    AccountFragment accountFragment = new AccountFragment();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNav);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.lost:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,lostFragment).commit();
                        return true;
                    case R.id.additem:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,addItemFragment).commit();
//                          Intent i = new Intent("AddItem");
//                          startActivity(i);
                        return true;
                    case R.id.found:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,foundFragment).commit();
                        return true;
                    case R.id.account:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,accountFragment).commit();
                        return true;

                }
                return false;
            }
        });
    }

    public void uploadImage(View v) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 3);
    }

    public void navigateToSignUp(View v) {
        Intent signUpScreen = new Intent("signup");
        startActivity(signUpScreen);
    }

    public void navigateToCardDetails(View v) {
        Intent cardDetailsScreen = new Intent("cardDetails");
        startActivity(cardDetailsScreen);

    }


}