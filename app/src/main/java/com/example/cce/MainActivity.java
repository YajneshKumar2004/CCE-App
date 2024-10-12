package com.example.cce;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.drawerLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                drawerLayout.closeDrawer(GravityCompat.START);
                if(id == R.id.nav_home)
                {
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    replaceFragment(new home());
                } else if (id == R.id.nav_events) {
                    Toast.makeText(MainActivity.this, "Events", Toast.LENGTH_SHORT).show();
                    replaceFragment(new events());
                } else if (id == R.id.nav_cgpa_calculator) {
                    Toast.makeText(MainActivity.this, "CGPA Calculator", Toast.LENGTH_SHORT).show();
                    replaceFragment(new cgpa_calculator());
                } else if (id == R.id.nav_access) {
                    Toast.makeText(MainActivity.this, "Welcome to ACCESS", Toast.LENGTH_SHORT).show();
                    replaceFragment(new access());
                } else if (id == R.id.nav_placement) {
                    Toast.makeText(MainActivity.this, "Placement", Toast.LENGTH_SHORT).show();
                    replaceFragment(new placement());
                } else if (id == R.id.sem1) {
                    Toast.makeText(MainActivity.this, "Opening Sem-1", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1GokPy1n2XleYE2vGCvUQFTVKbb8eDyPK?usp=drive_link");
                } else if (id == R.id.sem2) {
                    Toast.makeText(MainActivity.this, "Opening Sem-2", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1P_pjnLvhZCojqIGk_ihXXBhdO9_WzL-T?usp=drive_link");
                } else if (id == R.id.sem3) {
                    Toast.makeText(MainActivity.this, "Opening Sem-3", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1cKY86z10pLSf7FUpFUwm6qMB34oPrsIV?usp=drive_link");
                } else if (id == R.id.sem4) {
                    Toast.makeText(MainActivity.this, "Opening Sem-4", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1hQIrsaI6aHfss9psUO-7jv3kLNLPuSu0?usp=drive_link");
                } else if (id == R.id.sem5) {
                    Toast.makeText(MainActivity.this, "Opening Sem-5", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1hz2GT6Xwydq5ywCxlteCaAlHBX2GtymA?usp=drive_link");
                } else if (id == R.id.sem6) {
                    Toast.makeText(MainActivity.this, "Opening Sem-6", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1dS9jail-EK_wEVj79BlF383PVmU3ygCQ?usp=drive_link");
                } else if (id == R.id.sem7) {
                    Toast.makeText(MainActivity.this, "Opening Sem-7", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1DaX3fcqcmJyp0i_F3FbdYpomwzuJPhrD?usp=drive_link");
                } else if (id == R.id.sem8) {
                    Toast.makeText(MainActivity.this, "Opening Sem-8", Toast.LENGTH_SHORT).show();
                    goToUrl("https://drive.google.com/drive/folders/1-DKnr-xAW8aseZS7NaYj1zrbRLW2XdOS?usp=drive_link");
                } else{
                    return false;
                }
                return true;
            }
        });
    }

    // code to replace the fragment in activity_main.xml
    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }

    void goToUrl(String s)
    {
        try {
            Uri uri = Uri.parse(s);
            startActivity(new Intent(Intent.ACTION_VIEW, uri));
        }
        catch (Exception e){
            Toast.makeText(this, "No website linked", Toast.LENGTH_SHORT).show();
        }
    }
}