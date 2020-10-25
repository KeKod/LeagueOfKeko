package com.kekod.leagueofkeko

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page_masterkeko)

/*        if (BuildConfig.isFreemium) {
            btnMatchHistory.visibility = View.GONE
        }*/
    }
}