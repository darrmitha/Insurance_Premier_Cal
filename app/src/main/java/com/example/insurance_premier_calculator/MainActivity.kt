package com.example.insurance_premier_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

   lateinit var myData: PremiumModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData = ViewModelProviders.of(this).get(PremiumModel::class.java)

        display()

        btnCalculate.setOnClickListener(){
            myData.premiumAmount = getPremium()
            display()
        }

        btnReset.setOnClickListener {
            spinner.setSelection(0)
            radGroup.clearCheck()
            yes.setChecked(false)
            myData.premiumAmount = 0.0
        }
    }


    fun display() {
        if (myData.premiumAmount != 0.0)
        calculatePremium.text = myData.premiumAmount.toString()
    }

    fun getPremium() :Double{

        return when (spinner.selectedItemPosition){
            0 -> 60.00
            1 -> 70.00 +
                    (if (rbtnMale.isChecked) 50.00 else 0.0) +
                    (if (yes.isChecked) 100.00 else 0.0 )
            2 -> 90.00 +
                    (if (rbtnMale.isChecked) 100.00 else 0.0) +
                    (if (yes.isChecked) 150.00 else 0.0)
            3 -> 120.00 +
                    (if (rbtnMale.isChecked) 150.00 else 0.0) +
                    (if (yes.isChecked) 200.00 else 0.0)
            4 -> 150.00 +
                    (if (rbtnMale.isChecked) 200.00 else 0.0) +
                    (if (yes.isChecked) 250.00 else 0.0)
            else -> 150.00 +
            (if (rbtnMale.isChecked) 200.00 else 0.0) +
                    (if (yes.isChecked) 300.00 else 0.0)
            }


    }
}
