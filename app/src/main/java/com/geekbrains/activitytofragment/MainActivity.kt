package com.geekbrains.activitytofragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geekbrains.activitytofragment.databinding.ActivityMainBinding
import com.geekbrains.activitytofragment.ui.FirstFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_main_activity, FirstFragment.newInstance())
                .commitNow()
        }


//        buttonMain()
    }

//    private fun buttonMain() {
//        binding.buttonMain.setOnClickListener {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.container_main_activity, FirstFragment.newInstance())
//                .commit()
//        }
//    }
}