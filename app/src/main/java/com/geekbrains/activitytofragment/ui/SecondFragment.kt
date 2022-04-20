package com.geekbrains.activitytofragment.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geekbrains.activitytofragment.MainActivity
import com.geekbrains.activitytofragment.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonSecond()
    }

    private fun buttonSecond() {
        binding.buttonSecond.setOnClickListener {
            val intent = Intent(activity?.applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}