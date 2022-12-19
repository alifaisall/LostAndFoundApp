package com.example.lostandfound;

import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.lostandfound.Fragments.SignInFragment;
import com.example.lostandfound.Fragments.SignUpFragment;

public class Account extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    SignUpFragment signUpFragment = new SignUpFragment();
    SignInFragment signInFragment = new SignInFragment();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        setContentView(R.layout.activity_account);

        getSupportFragmentManager().beginTransaction().replace(R.id.accountContainer, signInFragment).commit();

    }

    public void showSignUp(View v) {
        getSupportFragmentManager().beginTransaction().replace(R.id.accountContainer, signUpFragment).commit();
    }
    public void showLogin(View v) {
        getSupportFragmentManager().beginTransaction().replace(R.id.accountContainer, signInFragment).commit();

    }

    public void backToMain(View v) {
        super.onBackPressed();
    }

}