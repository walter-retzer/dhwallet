package com.digitalhouse.dhwallet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, TransactionFragment.newInstance("R$ 44,35", "536"))
            .addToBackStack("transaction_fragment")
            .commit()

        findViewById<Button>(R.id.bnt_next).setOnClickListener{
            navigateToTransfer()
        }

    }

    private fun navigateToTransfer(){
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, TransferFragment())
            .addToBackStack(null)
            .commit()
    }
}
