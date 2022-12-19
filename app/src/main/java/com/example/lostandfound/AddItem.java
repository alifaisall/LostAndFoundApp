package com.example.lostandfound;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.lostandfound.DatabaseAndTables.DatabaseHandler;
import com.example.lostandfound.DatabaseAndTables.Item;

import java.util.Calendar;

public class AddItem extends AppCompatActivity {
    Spinner typeSpinner;
    EditText titleET;
    EditText descriptionET;
    Spinner categorySpinner;
    EditText locationET;
    Button dateButton;
    Button imageButton;
    DatePickerDialog.OnDateSetListener dateSetListener;
    String imageUri;
    int year;
    int month;
    int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.custom_actionbar);
        setContentView(R.layout.activity_add_item);

        typeSpinner = (Spinner) findViewById(R.id.spinnerCategory5);
        titleET = (EditText) findViewById(R.id.edTitle3);
        descriptionET = (EditText) findViewById(R.id.edDescription3);
        categorySpinner = (Spinner) findViewById(R.id.spinnerCategory6);
        locationET = (EditText) findViewById(R.id.edLocation3);
        dateButton = (Button) findViewById(R.id.btnDatePicker);
        imageButton = (Button) findViewById(R.id.btnGallery3);
        Calendar calender = Calendar.getInstance();
        year = calender.get(Calendar.YEAR);
        month = calender.get(Calendar.MONTH);
        day = calender.get(Calendar.DAY_OF_MONTH);


        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(AddItem.this, dateSetListener, year, month, day);
                datePickerDialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker datePicker, int i, int i1, int i2) {
                year = i;
                month = i1;
                day = i2;
                dateButton.setText(day + "/" + month + "/" + year);
            }
        };

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, 1);
                // get the image uri
                imageUri = intent.getData().toString();
                // print it in the console
                System.out.println(imageUri);

            }
        });



    }

    public void back(View v) {
        super.onBackPressed();
    }

    public void uploadImage(View v) {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, 3);
    }

    public void addItem(View v) {

        String type = typeSpinner.getSelectedItem().toString();
        String title = titleET.getText().toString();
        String description = descriptionET.getText().toString();
        String category = categorySpinner.getSelectedItem().toString();
        String location = locationET.getText().toString();
        String date = dateButton.getText().toString();

        if(imageUri == null) {
            Toast.makeText(this, "Select an Image", Toast.LENGTH_SHORT).show();
            return;
        }if(date == "Date"){
            Toast.makeText(this, "Select the date", Toast.LENGTH_SHORT).show();
            return;
        }
        if(title == null || description == null || location == null || type == null || category == null){
            Toast.makeText(this, "Fill all the fields", Toast.LENGTH_SHORT).show();
            return;
        }

        Item item = new Item(type, title, description, category, "OPEN", date, location, imageUri);
        new DatabaseHandler(AddItem.this).addItem(item);


    }
}