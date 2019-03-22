package com.freelancer.buivanphuc.russianenglish.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.database.CoppyDatabase;
import com.freelancer.buivanphuc.russianenglish.database.createDatabase;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentFavoretis;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentSeach;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentTranslator;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentWeb;
import com.freelancer.buivanphuc.russianenglish.fragment.HistotyFragment;
import com.freelancer.buivanphuc.russianenglish.service.FloatingViewService;
import com.freelancer.buivanphuc.russianenglish.util.NavigationUtil;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        BottomNavigationView.OnNavigationItemSelectedListener {
    private static final int SYSTEM_ALERT_WINDOW_PERMISSION = 2084;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolBar;
    FragmentManager fragmentManager;
    FrameLayout frameTrangChu;
    CoppyDatabase mCoppyDatabase;
    createDatabase mCreate;
    BottomNavigationView bottomNavigationView;
    Boolean mCheckFastKey = false;
    public static boolean sCheckMainActivity = false;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerTrangChu);
        navigationView = findViewById(R.id.NavigationViewTrangChu);
        toolBar = findViewById(R.id.toolbar);
        frameTrangChu = findViewById(R.id.frameTrangChu);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolBar.setTitle("Home");

        mCoppyDatabase = new CoppyDatabase(this);
        mCoppyDatabase.createDB();
        mCreate = new createDatabase(this);
        mCreate.open();

        setSupportActionBar(toolBar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.mo, R.string.dong) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragmentManager = getSupportFragmentManager();
    }

    private void IntentCategoryActivity(String title) {
        Intent intent = new Intent(this, CategoryActivity.class);
        intent.putExtra("check", title);
        startActivity(intent);
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nouns:
                IntentCategoryActivity("Nouns");
                break;
            case R.id.article:
                IntentCategoryActivity("Article");
                break;
            case R.id.pronoun:
                IntentCategoryActivity("Pronoun");
                break;
            case R.id.numberal:
                IntentCategoryActivity("Numberal");
                break;
            case R.id.adjective:
                IntentCategoryActivity("Adjective");
                break;
            case R.id.adverb:
                IntentCategoryActivity("Adverb");
                break;
            case R.id.verb:
                IntentCategoryActivity("Verb");
                break;
            case R.id.preposition:
                IntentCategoryActivity("Preposition");
                break;
            case R.id.conjunction:
                IntentCategoryActivity("Conjunction");
                break;
            case R.id.particles:
                IntentCategoryActivity("Particles");
                break;
            case R.id.interjection:
                IntentCategoryActivity("Interjection");
                break;
            case R.id.nav_book1:
                IntentCategoryActivity("Book 1");
                break;
            case R.id.nav_book2:
                IntentCategoryActivity("Book 2");
                break;
            case R.id.nav_search:
                menuItem.setChecked(true);
                FragmentTransaction transactionSearch = fragmentManager.beginTransaction();
                FragmentSeach fragmentSeach = new FragmentSeach();
                transactionSearch.replace(R.id.frameTrangChu, fragmentSeach);
                transactionSearch.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_history:
                menuItem.setChecked(true);
                FragmentTransaction transactionHistory = fragmentManager.beginTransaction();
                HistotyFragment histotyFragment = new HistotyFragment();
                transactionHistory.replace(R.id.frameTrangChu, histotyFragment);
                transactionHistory.commit();
                break;
            case R.id.nav_favorite:
                menuItem.setChecked(true);
                FragmentTransaction transactionFa = fragmentManager.beginTransaction();
                FragmentFavoretis fragmentFavoretis = new FragmentFavoretis();
                transactionFa.replace(R.id.frameTrangChu, fragmentFavoretis);
                transactionFa.commit();
                break;
            case R.id.transator:
                menuItem.setChecked(true);
                FragmentTransaction transactiontransator = fragmentManager.beginTransaction();
                FragmentTranslator fragmenttransator = new FragmentTranslator();
                transactiontransator.replace(R.id.frameTrangChu, fragmenttransator);
                transactiontransator.commit();
                break;
            case R.id.traslate_web:
                menuItem.setChecked(true);
                FragmentTransaction traslate_web = fragmentManager.beginTransaction();
                FragmentWeb fragmentWeb = new FragmentWeb();
                traslate_web.replace(R.id.frameTrangChu, fragmentWeb);
                traslate_web.commit();
                break;
            case R.id.nav_fast:
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    startService(new Intent(MainActivity.this, FloatingViewService.class));
                } else if (Settings.canDrawOverlays(this)) {
                    startService(new Intent(MainActivity.this, FloatingViewService.class));
                } else {
                    askPermission();
                }
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_share:
                try {
                    NavigationUtil.Share(this);
                    drawerLayout.closeDrawers();
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            case R.id.nav_feedback:
                NavigationUtil.feedBack(this);
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_rate:
                NavigationUtil.Rate(this);
                drawerLayout.closeDrawers();
                break;
        }
        return false;
    }


    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }

    private void askPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, SYSTEM_ALERT_WINDOW_PERMISSION);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SYSTEM_ALERT_WINDOW_PERMISSION) {
            {
                startService(new Intent(MainActivity.this, FloatingViewService.class));
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentTransaction transactionSearch = fragmentManager.beginTransaction();
        FragmentSeach fragmentSeach = new FragmentSeach();
        transactionSearch.replace(R.id.frameTrangChu, fragmentSeach);
        transactionSearch.commit();

        drawerLayout.closeDrawers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sCheckMainActivity = true;
    }
}
