package id.undika.pertemuan10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    FragmentMovie fragmentMovie = new FragmentMovie();
    BottomNavigationView botNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNav = findViewById(R.id.bottom_navigation);
        botNav.setOnItemSelectedListener(this);
        botNav.setSelectedItemId(R.id.menu_movies);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_movies:
                getSupportFragmentManager().beginTransaction().replace(R.id.containerLayout, fragmentMovie).commit();
                return true;
            case R.id.menu_tv:
                return true;
        }
        return false;
    }
}