package com.amicritas.e_graments;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.scwang.wave.MultiWaveHeader;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class UserProfileActivity extends AppCompatActivity {
    private TextView mTextMessage;
    BottomNavigationView navView;
    LinearLayout profileCard,postCard,messageCard;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);


        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //wave view
        waveView();

        init();

        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UserProfileActivity.this,ProfileActivity.class));
            }
        });



    }

    private void init() {

        profileCard = findViewById(R.id.profile_card);
        postCard = findViewById(R.id.post_card);
        messageCard = findViewById(R.id.message_card);

    }


    //method for wave view
    public void waveView(){
        MultiWaveHeader waveHeader = findViewById(R.id.waveHeader);
        String[] waves = new String[]{
                "70,25,1.4,1.4,-26",//wave-1:offsetX(dp),offsetY(dp),scaleX,scaleY,velocity(dp/s)
                "100,5,1.4,1.2,15",
                "420,0,1.15,1,-10",//wave-3:offsetX(dp),offsetY(dp),scaleX,scaleY,velocity(dp/s)
                "520,10,1.7,1.5,20",
                "220,0,1,1,-15",
        };
        waveHeader.setWaves(TextUtils.join(" ", Arrays.asList(waves)));// custom
        waveHeader.setWaves("PairWave");// default two waves
        waveHeader.setWaves("MultiWave");// default five waves
    }


    //navigationView
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_assistant:
                   // mTextMessage.setText(R.string.title_assistant);
                    Toast.makeText(UserProfileActivity.this, "click assistant", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_news:
                   // mTextMessage.setText(R.string.title_news);
                    Toast.makeText(UserProfileActivity.this, "click news", Toast.LENGTH_SHORT).show();

                    return true;
                case R.id.navigation_premium:
                  //  mTextMessage.setText(R.string.title_settings);
                    Toast.makeText(UserProfileActivity.this, "click premium", Toast.LENGTH_SHORT).show();

                    return true;

                case R.id.navigation_setting:
                    //  mTextMessage.setText(R.string.title_settings);
                    Toast.makeText(UserProfileActivity.this, "click setting", Toast.LENGTH_SHORT).show();

                    return true;
            }
            return false;
        }
    };


}
