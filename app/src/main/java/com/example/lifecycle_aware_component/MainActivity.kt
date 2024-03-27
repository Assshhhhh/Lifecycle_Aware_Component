package com.example.lifecycle_aware_component

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        lifecycle.addObserver(Observer())

        Log.d("MAIN", "Activity - ON CREATE")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MAIN", "Activity - ON RESUME")

    }

    override fun onPause() {
        super.onPause()
        Log.d("MAIN", "Activity - ON PAUSE")

    }

    override fun onStop() {
        super.onStop()
        Log.d("MAIN", "Activity - ON STOP")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MAIN", "Activity - ON DESTROY")

    }

}