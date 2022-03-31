package com.sbilife.quatify

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.sbilife.quatify.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding: ActivitySplashScreenBinding? = null
    //not null asserted operator (!!) executes function even name is null
    // throws error if name is null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash_screen)
        _binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2500)

    }
}