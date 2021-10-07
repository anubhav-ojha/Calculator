package com.techmaze.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resul_t.*

class resulT : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resul_t)

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