package com.kelth.mymobileads;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds; // KEL

// KEL Banner
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

// KEL
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends Activity {

    private static final String ADMOB_ID = "ca-app-pub-3940256099942544~3347511713"; // For testing purpose
    private static final String TAG = MainActivity.class.getSimpleName();

    private AdView mAdView; // KEL Banner
    private InterstitialAd mInterstitialAd; // KEL Full screen ad

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // KEL
        MobileAds.initialize(this, ADMOB_ID);

        // KEL Banner
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.d(TAG, "onAdLoaded");
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
                Log.d(TAG, "onAdOpened");
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
                Log.d(TAG, "onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                super.onAdFailedToLoad(errorCode);
                Log.d(TAG, "onAdLoaded: " + errorCode);
            }
        });


        // KEL Full screen ad
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }
        });
    }

    public void onBtnClick(View view) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }
}
