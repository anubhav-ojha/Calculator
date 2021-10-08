package com.techMaze.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_resul_t.*

class resulT : AppCompatActivity() {
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resul_t)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                super.onAdLoaded()
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.

                super.onAdFailedToLoad(adError)
                mAdView.loadAd(adRequest)

            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                super.onAdOpened()
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                super.onAdClicked()
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }

        val bmi = intent.getDoubleExtra("bmi", -1.0)
        if(bmi == -1.0)
        {
            containerR.visibility = View.GONE
        }
        else{
            bmiValueTV.text = bmi.toString()
            if(bmi < 18.5)
            {
                containerR.setBackgroundResource(R.drawable.yellow_bg)
                bmiFlagImage.setImageResource(R.drawable.exclamation_mark)
                bmiLableTv.text = "You are UnderWeight"
                commentTV.text = "Here are some advice to help you :"
                advice1IMG.setImageResource(R.drawable.nowater)
                advice1TV.text = "Don't drink water before meals"
                advice2IMG.setImageResource(R.drawable.bigmeal)
                advice2TV.text = "Use bigger plates"
                advice3TV.text ="Get quality sleep"

            } else {
                if (bmi > 25){
                    containerR.setBackgroundResource(R.drawable.red_bg)
                    bmiFlagImage.setImageResource(R.drawable.warnings)
                    bmiLableTv.text = "You are OverWeight"
                    commentTV.text = "Here are some advice to help you :"
                    advice1IMG.setImageResource(R.drawable.water)
                    advice1TV.text = "Don't drink water before meals"
                    advice2IMG.setImageResource(R.drawable.twoeggs)
                    advice2TV.text = "Eat only two meals per day and make sure they are high in protein"
                    advice3IMG.setImageResource(R.drawable.nosugar)

                    advice3TV.text ="Drink coffe or tea and avoid sugary food "
                }
            }
        }
    }

}