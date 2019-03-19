package com.freelancer.buivanphuc.russianenglish.activity;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.annotation.NonNull;
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
import android.widget.TextView;
import android.widget.Toast;

import com.freelancer.buivanphuc.russianenglish.R;
import com.freelancer.buivanphuc.russianenglish.database.CoppyDatabase;
import com.freelancer.buivanphuc.russianenglish.database.createDatabase;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentAdjective;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentArticle;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentBook1;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentBook2;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentConjunction;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentFavoretis;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentInterjection;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentNouns;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentNumberal;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentParticles;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentPreposition;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentPronoun;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentSeach;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentTranslator;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentVerb;
import com.freelancer.buivanphuc.russianenglish.fragment.FragmentWeb;
import com.freelancer.buivanphuc.russianenglish.fragment.HistotyFragment;
import com.freelancer.buivanphuc.russianenglish.interfaces.IGetLinks;
import com.freelancer.buivanphuc.russianenglish.service.FloatingViewService;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, IGetLinks,
        BottomNavigationView.OnNavigationItemSelectedListener {
    private static final int SYSTEM_ALERT_WINDOW_PERMISSION = 2084;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolBar;
    FragmentManager fragmentManager;
    FrameLayout frameTrangChu,clearFocus;
    CoppyDatabase mCoppyDatabase;
    createDatabase mCreate;
    BottomNavigationView bottomNavigationView;
    TextView txtFocus;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawerTrangChu);
        navigationView = findViewById(R.id.NavigationViewTrangChu);
        toolBar = findViewById(R.id.toolbar);
        frameTrangChu = findViewById(R.id.frameTrangChu);
        clearFocus = findViewById(R.id.clearFocus);
        clearFocus.clearFocus();
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolBar.setTitle("Home");

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

        mCoppyDatabase = new CoppyDatabase(this);
        mCoppyDatabase.createDB();
        mCreate = new createDatabase(this);
        mCreate.open();
        fragmentManager = getSupportFragmentManager();


    }
    @SuppressLint("ResourceAsColor")
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.nouns:
                FragmentTransaction transactionNouns = fragmentManager.beginTransaction();
                FragmentNouns fragmentNouns = new FragmentNouns();
                fragmentNouns.setInterface(this);
                transactionNouns.replace(R.id.frameTrangChu, fragmentNouns);
                transactionNouns.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.article:
                FragmentTransaction transactionNounsArticle = fragmentManager.beginTransaction();
                FragmentArticle fragmentNounsArticle = new FragmentArticle();
                fragmentNounsArticle.setInterface(this);
                transactionNounsArticle.replace(R.id.frameTrangChu, fragmentNounsArticle);
                transactionNounsArticle.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.pronoun:
                FragmentTransaction transactionNounsPronoun = fragmentManager.beginTransaction();
                FragmentPronoun fragmentNounsPronoun = new FragmentPronoun();
                fragmentNounsPronoun.setInterface(this);
                transactionNounsPronoun.replace(R.id.frameTrangChu, fragmentNounsPronoun);
                transactionNounsPronoun.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.numberal:
                FragmentTransaction transactionNounsnumberal = fragmentManager.beginTransaction();
                FragmentNumberal fragmentNounsnumberal = new FragmentNumberal();
                fragmentNounsnumberal.setInterface(this);
                transactionNounsnumberal.replace(R.id.frameTrangChu, fragmentNounsnumberal);
                transactionNounsnumberal.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.adjective:
                FragmentTransaction transactionNounsadjective = fragmentManager.beginTransaction();
                FragmentAdjective fragmentNounsadjective = new FragmentAdjective();
                fragmentNounsadjective.setInterface(this);
                transactionNounsadjective.replace(R.id.frameTrangChu, fragmentNounsadjective);
                transactionNounsadjective.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.adverb:
                FragmentTransaction transactionNounsadverb = fragmentManager.beginTransaction();
                FragmentVerb fragmentNounsadverb = new FragmentVerb();
                fragmentNounsadverb.setInterface(this);
                transactionNounsadverb.replace(R.id.frameTrangChu, fragmentNounsadverb);
                transactionNounsadverb.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.verb:
                FragmentTransaction transactionNounsverb = fragmentManager.beginTransaction();
                FragmentVerb fragmentNounsverb = new FragmentVerb();
                fragmentNounsverb.setInterface(this);
                transactionNounsverb.replace(R.id.frameTrangChu, fragmentNounsverb);
                transactionNounsverb.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.preposition:
                FragmentTransaction transactionNounspreposition = fragmentManager.beginTransaction();
                FragmentPreposition fragmentNounspreposition = new FragmentPreposition();
                fragmentNounspreposition.setInterface(this);
                transactionNounspreposition.replace(R.id.frameTrangChu, fragmentNounspreposition);
                transactionNounspreposition.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.conjunction:
                FragmentTransaction transactionNounsconjunction = fragmentManager.beginTransaction();
                FragmentConjunction fragmentNounsconjunction = new FragmentConjunction();
                fragmentNounsconjunction.setInterface(this);
                transactionNounsconjunction.replace(R.id.frameTrangChu, fragmentNounsconjunction);
                transactionNounsconjunction.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.particles:
                FragmentTransaction transactionNounsparticles = fragmentManager.beginTransaction();
                FragmentParticles fragmentNounsparticles = new FragmentParticles();
                fragmentNounsparticles.setInterface(this);
                transactionNounsparticles.replace(R.id.frameTrangChu, fragmentNounsparticles);
                transactionNounsparticles.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.interjection:
                FragmentTransaction transactionNounsinterjection = fragmentManager.beginTransaction();
                FragmentInterjection fragmentNounsinterjection = new FragmentInterjection();
                fragmentNounsinterjection.setInterface(this);
                transactionNounsinterjection.replace(R.id.frameTrangChu, fragmentNounsinterjection);
                transactionNounsinterjection.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_book1:
                FragmentTransaction transactionNounsbook1 = fragmentManager.beginTransaction();
                FragmentBook1 fragmentNounsbook1 = new FragmentBook1();
                fragmentNounsbook1.setInterface(this);
                transactionNounsbook1.replace(R.id.frameTrangChu, fragmentNounsbook1);
                transactionNounsbook1.commit();
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_book2:
                FragmentTransaction transactionNounsbook2 = fragmentManager.beginTransaction();
                FragmentBook2 fragmentNounsbook2 = new FragmentBook2();
                fragmentNounsbook2.setInterface(this);
                transactionNounsbook2.replace(R.id.frameTrangChu, fragmentNounsbook2);
                transactionNounsbook2.commit();
                drawerLayout.closeDrawers();
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
                menuItem.setCheckable(true);
                FragmentTransaction transactiontransator = fragmentManager.beginTransaction();
                FragmentTranslator fragmenttransator = new FragmentTranslator();
                transactiontransator.replace(R.id.frameTrangChu, fragmenttransator);
                transactiontransator.commit();
                break;
            case R.id.traslate_web:
                menuItem.setChecked(true);
                menuItem.setCheckable(true);
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
                    Toast.makeText(this, "You need System Alert Window Permission to do this", Toast.LENGTH_SHORT).show();
                }
                drawerLayout.closeDrawers();
                break;
            case R.id.nav_share:
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage = "\nLet me recommend you this application\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=com.hdpsolution.englishrussiandict";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                    //e.toString();
                }
                break;
            case R.id.nav_feedback:
                Intent Email = new Intent(Intent.ACTION_SEND);
                Email.setType("text/email");
                Email.putExtra(Intent.EXTRA_EMAIL, new String[]{"studyfirebase@gmail.com"});
                Email.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                Email.putExtra(Intent.EXTRA_TEXT, "Dear ...," + "");
                startActivity(Intent.createChooser(Email, "Send Feedback:"));
                break;
            case R.id.nav_rate:
                Uri uri = Uri.parse("market://details?id=" + "com.hdpsolution.englishrussiandict");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
                goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                        Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                        Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                try {
                    startActivity(goToMarket);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://play.google.com/store/apps/details?id=com.hdpsolution.englishrussiandict")));
                }
                break;
        }
        return false;
    }

    @Override
    public void getLink(String link) {

        Intent intent = new Intent(this, GrammarActivity.class);
        intent.putExtra("link", link);
        startActivity(intent);
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
    protected void onResume() {
        super.onResume();

        FragmentTransaction transactionSearch = fragmentManager.beginTransaction();
        FragmentSeach fragmentSeach = new FragmentSeach();
        transactionSearch.replace(R.id.frameTrangChu, fragmentSeach);
        transactionSearch.commit();
        frameTrangChu.clearFocus();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !Settings.canDrawOverlays(this)) {
            askPermission();
        }
    }
}
