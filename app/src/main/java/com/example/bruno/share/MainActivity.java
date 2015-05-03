package com.example.bruno.share;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TabHost tabHost = getTabHost();

        TabSpec sharespec = tabHost.newTabSpec("Share");
        sharespec.setIndicator("Share");
        Intent photosIntent = new Intent(this, Share.class);
        sharespec.setContent(photosIntent);

        TabSpec opiniaospec = tabHost.newTabSpec("Opiniao");
        opiniaospec.setIndicator("Opiniao");
        Intent songsIntent = new Intent(this, Opiniao.class);
        opiniaospec.setContent(songsIntent);

        TabSpec aderirspec = tabHost.newTabSpec("Aderir");
        aderirspec.setIndicator("Aderir");
        Intent videosIntent = new Intent(this, Aderir.class);
        aderirspec.setContent(videosIntent);

        tabHost.addTab(sharespec);
        tabHost.addTab(opiniaospec);
        tabHost.addTab(aderirspec);
    }

}
