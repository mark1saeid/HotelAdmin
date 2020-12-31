package com.troy.saferadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CreatePost extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_post);


        final EditText hName = findViewById(R.id.hName);
        final EditText hplace = findViewById(R.id.hLocation);
        final EditText hPrice = findViewById(R.id.hPrice);
        final EditText details = findViewById(R.id.formDetails);
        final EditText hBeds = findViewById(R.id.hbed);
        final EditText hFood = findViewById(R.id.hfood);
        final EditText hPool = findViewById(R.id.hpool);
        final EditText hStars = findViewById(R.id.hstars);
        final EditText hLink = findViewById(R.id.hlink);
        final EditText himage1 = findViewById(R.id.himag1);
        final EditText himage2 = findViewById(R.id.himag2);
        final EditText himage3 = findViewById(R.id.himag3);
        final EditText himage4 = findViewById(R.id.himag4);




        Button order = findViewById(R.id.sub);
        order.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (hName.getText().toString().equals("")||hplace.getText().toString().equals("")||hPrice.getText().toString().equals("")||hBeds.getText().toString().equals("")||hFood.getText().toString().equals("")||hPool.getText().toString().equals("")||hStars.getText().toString().equals("")||himage1.getText().toString().equals("")||hLink.getText().toString().equals("")){
                    Toast.makeText(CreatePost.this,"Please fill all info",Toast.LENGTH_LONG).show();


                }else {
                    FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference mDbRef = mDatabase.getReference().child("hotels").push();
                    mDbRef.child("bednum").setValue(hBeds.getText().toString());
                    mDbRef.child("desc").setValue(details.getText().toString());
                    mDbRef.child("food").setValue(hFood.getText().toString());
                    mDbRef.child("hotelname").setValue(hName.getText().toString());
                    mDbRef.child("image1").setValue(himage2.getText().toString());
                    mDbRef.child("image2").setValue(himage3.getText().toString());
                    mDbRef.child("image3").setValue(himage4.getText().toString());
                    mDbRef.child("imege").setValue(himage1.getText().toString());
                    mDbRef.child("link").setValue(hLink.getText().toString());
                    mDbRef.child("place").setValue(hplace.getText().toString());
                    mDbRef.child("pools").setValue(hPool.getText().toString());
                    mDbRef.child("price").setValue(hPrice.getText().toString());
                    mDbRef.child("stars").setValue(hStars.getText().toString());



                    Toast.makeText(CreatePost.this,"your Post submitted",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent (CreatePost.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });



    }


    public void back(View view) {
        Intent intent = new Intent (CreatePost.this, MainActivity.class);
        startActivity(intent);
    }
}
