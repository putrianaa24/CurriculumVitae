package space.noviardita.cv_putri;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import space.noviardita.cv_putri.fragment.CertFragment;
import space.noviardita.cv_putri.fragment.InfoFragment;
import space.noviardita.cv_putri.fragment.MeFragment;
import space.noviardita.cv_putri.fragment.SkillFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new MeFragment());
    }
    private boolean loadFragment(Fragment fragment){
        if (fragment != null){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fl_container, fragment);
            fragmentTransaction.commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
        Fragment fragment = null;
        switch (menuItem.getItemId()){
            case R.id.item_me:
                fragment = new MeFragment();
                break;
            case R.id.item_cert:
                fragment = new CertFragment();
                break;
            case R.id.item_skill:
                fragment = new SkillFragment();
                break;
            case R.id.item_info:
                fragment = new InfoFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
