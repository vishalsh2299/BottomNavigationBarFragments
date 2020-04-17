package com.example.bottomnavigationbarfragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private FragmentHome fragmentHome;
    private FragmentNotification fragmentNotification;
    private FragmentPerson fragmentPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.main_nav);
        frameLayout = findViewById(R.id.main_frame);

        fragmentHome = new FragmentHome();
        fragmentNotification = new FragmentNotification();
        fragmentPerson = new FragmentPerson();

        changeFragment(fragmentHome);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        changeFragment(fragmentHome);
                        return true;
                    case R.id.messages:
                        changeFragment(fragmentNotification);
                        return true;
                    case R.id.profile:
                        changeFragment(fragmentPerson);
                        return true;
                    default:
                        return false;
                }
            }
        });
    }

    private void changeFragment(Fragment fragment) {

        FragmentTransaction fTransaction = getSupportFragmentManager().beginTransaction();
        fTransaction.replace(R.id.main_frame,fragment);
        fTransaction.commit();
    }
}
