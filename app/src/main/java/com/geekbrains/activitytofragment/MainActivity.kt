package com.geekbrains.activitytofragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.geekbrains.activitytofragment.databinding.ActivityMainBinding
import com.geekbrains.activitytofragment.domain.Controller
import com.geekbrains.activitytofragment.domain.TestEntityData
import com.geekbrains.activitytofragment.ui.FirstFragment
import com.geekbrains.activitytofragment.ui.SecondFragment


class MainActivity : AppCompatActivity(), Controller {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val frag: Fragment = FirstFragment()
            frag.retainInstance = true
            supportFragmentManager.beginTransaction()
                .replace(R.id.container_main_activity, FirstFragment.newInstance())
                .commitNow()
        }

//        buttonMain()
    }

    override fun openSecondFragment(testData: TestEntityData) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.container_main_activity, SecondFragment.newInstance(testData))
            .commit()
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