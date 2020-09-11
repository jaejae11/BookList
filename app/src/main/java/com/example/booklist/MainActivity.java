package com.example.booklist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    boolean check=false;
    Button buttonFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonFav = (Button)findViewById(R.id.btnFav);

        buttonFav.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                if (check==false){
                    check = true;
                    Toast.makeText(MainActivity.this, "Added into My Favorite.", Toast.LENGTH_SHORT).show();
                    buttonFav.setBackgroundResource(R.drawable.ic_action_favorite_clicked);
                }
                else if (check==true){
                    check = false;
                    Toast.makeText(MainActivity.this, "Removed from My Favorite.", Toast.LENGTH_SHORT).show();
                    buttonFav.setBackgroundResource(R.drawable.ic_action_favorite_before);
                }
            }

        });

    }


    public void borrowBook(View view) {
        Intent intent = new Intent(this, BorrowBook.class);
        startActivity(intent);
    }
}