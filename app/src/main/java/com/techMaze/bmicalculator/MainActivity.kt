package com.techMaze.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.*
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}

         mAdView = findViewById(R.id.adView)
         val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                super.onAdLoaded()
               // Toast.makeText(this@MainActivity, "Add loaded" )
                // Code to be executed when an ad finishes loading.
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

        calculateBtn.setOnClickListener {

            if(heightEDT.text.isNotEmpty() && weightEDT.text.isNotEmpty()){

                val weight = weightEDT.text.toString().toDouble()
                val height = heightEDT.text.toString().toDouble()/100

                if (weight > 0 && weight < 600 && height > 0 && height < 2.5 ) {
                    val intent = Intent(this@MainActivity, resulT::class.java)
                    intent.putExtra("bmi",calculateBMI(weight,height))
                    startActivity(intent)

                }
                else
                {
                    showError("Incorrect Values")
                }

            }
            else
            {
                showError("Incorrect Values")
            }
        }

    }
    private fun showError(errorMsg: String)
    {
        val snackbar = Snackbar.make(container,"error: $errorMsg !", Snackbar.LENGTH_LONG)
        snackbar.view.setBackgroundResource(R.color.colorRed)
        snackbar.show()
    }
    private fun calculateBMI(weight: Double, height: Double) = BigDecimal(weight/(height * height))
        .setScale(2,RoundingMode.HALF_EVEN).toDouble()
}