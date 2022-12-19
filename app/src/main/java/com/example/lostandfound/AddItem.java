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

import com.example.lostandfound.Fragments.SignInFragment;
import com.example.lostandfound.Fragments.AddItemFragment;
import com.example.lostandfound.Fragments.FoundFragment;
import com.example.lostandfound.Fragments.HomeFragment;
import com.example.lostandfound.Fragments.LostFragment;

public class AddItem extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        setContentView(R.layout.activity_add_item);


    }

    public void back(View v) {
        super.onBackPressed();
    }

    public void uploadImage(View v) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 3);
    }
}