package com.freelancer.buivanphuc.russianenglish.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.adapter.CategoryAdapter;
import com.freelancer.buivanphuc.russianenglish.dto.CategoryDTO;
import com.freelancer.buivanphuc.russianenglish.service.FloatingViewService;
import com.freelancer.buivanphuc.russianenglish.util.CategoryUtil;
import com.freelancer.buivanphuc.russianenglish.util.NavigationUtil;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ListView listView;
    String check = "";
    List<CategoryDTO> list;
    CategoryAdapter categoryAdapter;
    private static final int SYSTEM_ALERT_WINDOW_PERMISSION = 204;
    public static Boolean mCheckCategoryActivity = false;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_category);
        drawerLayout = findViewById(R.id.drawerTrangChu);
        navigationView = findViewById(R.id.NavigationViewTrangChu);
        toolBar = findViewById(R.id.toolbar);
        listView = findViewById(R.id.lvCategory);
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
        check = getIntent().getStringExtra("check");
        toolBar.setTitle(check);
        setTitle(check);
        init();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void init() {
        if (check.equals("Nouns")) {
            list = CategoryUtil.addNouns();
        } else if (check.equals("Article")) {
            list = CategoryUtil.addArticle();
        } else if (check.equals("Pronoun")) {
            list = CategoryUtil.addPronoun();
        } else if (check.equals("Numberal")) {
            list = CategoryUtil.addNumberal();
        } else if (check.equals("Adjective")) {
            list = CategoryUtil.addAdjective();
        } else if (check.equals("Adverb")) {
            list = CategoryUtil.addAdverb();
        } else if (check.equals("Verb")) {
            list = CategoryUtil.addVerb();
        } else if (check.equals("Preposition")) {
            list = CategoryUtil.addPreposition();
        } else if (check.equals("Conjunction")) {
            list = CategoryUtil.addConjunction();
        } else if (check.equals("Particles")) {
            list = CategoryUtil.addParticles();
        } else if (check.equals("Interjection")) {
            list = CategoryUtil.addInterjection();
        } else if (check.equals("Book 1")) {
            list = CategoryUtil.addBookOne();
        } else if (check.equals("Book 2")) {
            list = CategoryUtil.addBookTwo();
        }
        setAdapter();
    }
    private void ItemCheck(){
        drawerLayout.closeDrawers();
        setTitle(list.get(0).getTitle());
        setAdapter();
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nouns:
                list = CategoryUtil.addNouns();
                ItemCheck();
                break;
            case R.id.article:
                list = CategoryUtil.addArticle();
                ItemCheck();
                break;
            case R.id.pronoun:
                list = CategoryUtil.addPronoun();
                ItemCheck();
                break;
            case R.id.numberal:
                list = CategoryUtil.addNumberal();
                ItemCheck();
                break;
            case R.id.adjective:
                list = CategoryUtil.addAdjective();
                ItemCheck();
                break;
            case R.id.adverb:
                list = CategoryUtil.addAdverb();
                ItemCheck();
                break;
            case R.id.verb:
                list = CategoryUtil.addVerb();
                ItemCheck();
                break;
            case R.id.preposition:
                list = CategoryUtil.addPreposition();
                ItemCheck();
                break;
            case R.id.conjunction:
                list = CategoryUtil.addConjunction();
                ItemCheck();
                break;
            case R.id.particles:
                list = CategoryUtil.addParticles();
                ItemCheck();
                break;
            case R.id.interjection:
                list = CategoryUtil.addInterjection();
                ItemCheck();
                break;
            case R.id.nav_book1:
                list = CategoryUtil.addBookOne();
                ItemCheck();
                break;
            case R.id.nav_book2:
                list = CategoryUtil.addBookTwo();
                ItemCheck();
                break;
            case R.id.nav_fast:
                menuItem.setChecked(true);
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                    startService(new Intent(CategoryActivity.this, FloatingViewService.class));
                } else if (Settings.canDrawOverlays(this)) {
                    startService(new Intent(CategoryActivity.this, FloatingViewService.class));
                } else {
                    askPermission();
                }
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_share:
                menuItem.setChecked(true);
                try {
                    NavigationUtil.Share(this);
                    drawerLayout.closeDrawers();
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            case R.id.nav_feedback:
                menuItem.setChecked(true);
                NavigationUtil.feedBack(this);
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_rate:
                menuItem.setChecked(true);
                NavigationUtil.Rate(this);
                drawerLayout.closeDrawers();
                break;
        }

        return false;
    }

    private void setAdapter() {
        categoryAdapter = new CategoryAdapter(this, R.layout.item_category, list);
        listView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();
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
                startService(new Intent(CategoryActivity.this, FloatingViewService.class));
            }

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCheckCategoryActivity = true;
    }
}
