package com.geekbrains.activitytofragment

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
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
        startSplash()
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

    private fun startSplash() {
        val version = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
        if (version) {
            val screen = installSplashScreen()
            screen.setOnExitAnimationListener { screenProvider ->
                ObjectAnimator.ofFloat(
                    screenProvider.view,
                    View.TRANSLATION_X,
                    0f,
                    screenProvider.view.height.toFloat()
                ).apply {
                    duration = 5000
                    interpolator = AnticipateInterpolator()
                    doOnEnd {
                        screenProvider.remove()
                    }
                }.start()
            }
        }
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