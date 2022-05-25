package com.altaf.kisahnabiapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.altaf.kisahnabiapp.R
import com.altaf.kisahnabiapp.data.KisahResponse

class DetailActivity : AppCompatActivity() {
    companion object(){
        const val EXTRA_DATA = "extra_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data = intent.getParcelableExtra<KisahResponse>(EXTRA_DATA) as KisahResponse
    }


}