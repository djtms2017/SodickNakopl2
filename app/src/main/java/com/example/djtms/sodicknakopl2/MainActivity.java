package com.example.djtms.sodicknakopl2;

import android.annotation.SuppressLint;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.WindowManager;


//для использования этих библиотек нужно в gradle прописать
//compile 'com.nineoldandroids:library:2.4.0'
//compile 'com.github.sd6352051.niftydialogeffects:niftydialogeffects:1.0.0@aar'


import com.example.djtms.sodicknakopl2.R;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;



public class MainActivity extends AppCompatActivity {

    NiftyDialogBuilder materialDesignAnimatedDialog;

    private SectionsPagerAdapter mSectionsPagerAdapter;


    private ViewPager mViewPager;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);


        materialDesignAnimatedDialog = NiftyDialogBuilder.getInstance(this);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    //Создание меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Создание меню
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    //Вызов меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Exit1();
        }

        if (id == R.id.about) {
            materialDesignAnimatedDialog
                    .withTitle("Sodick")
                    .withMessage("Расчет захода электрода и" + "\nнакопленной погрешности геротора" +
                    "\n\nКардаш Богдан 2017")
                    .withDialogColor("#1c90ec")
                    .withButton1Text("OK")
                    .withDuration(700)
                    .withEffect(Effectstype.Newspager)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            materialDesignAnimatedDialog.cancel();
                        }
                    })
                    .show();
        }



        return super.onOptionsItemSelected(item);
    }


    public void Exit1(){

        materialDesignAnimatedDialog
                .withTitle("Выход")
                .withMessage("Вы точно хотите выйти?")
                .withDialogColor("#1c90ec")
                .withButton1Text("OK")
                .withButton2Text("Cancel")
                .withDuration(700)
                .withEffect(Effectstype.Flipv)
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                   public void onClick(View v) {
                        materialDesignAnimatedDialog.cancel();
                    }
                })
                .show();

    }



    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    ZahodElectroda tab1 = new ZahodElectroda();
                    return tab1;
                case 1:
                    Nakoplennaya tab2 = new Nakoplennaya();
                    return tab2;

                default:
                    return null;


            }
        }


        @Override
        public int getCount() {
            // !!!! Обязательно нужно указывать сколько tab у тебя всего.
            return 2;
        }




    }
}
