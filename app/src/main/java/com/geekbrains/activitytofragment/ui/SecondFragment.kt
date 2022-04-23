package com.geekbrains.activitytofragment.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geekbrains.activitytofragment.MainActivity
import com.geekbrains.activitytofragment.databinding.FragmentSecondBinding
import com.geekbrains.activitytofragment.domain.TestEntityData


class SecondFragment : Fragment() {

    companion object {
        const val ARGS_KEY = "ARGS_KEY"

        fun newInstance(testEntityData: TestEntityData?) = SecondFragment().apply {
            arguments = Bundle()
            arguments?.putParcelable(ARGS_KEY, testEntityData)
        }
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
        detailTesting()
    }

    /*Задаем переданные данные*/
    private fun detailTesting() {
        val test = detailTestingArguments()
        if (test == null) {
            binding.textTesting.text
        } else {
            binding.textTesting.text = test.textId
        }
    }

    /*Передаем ключ с FirstFragment*/
    private fun detailTestingArguments(): TestEntityData? {
        return arguments?.getParcelable(ARGS_KEY)
//            ?: throw IllegalStateException("Забыли в аргументы положит ключ !!!")
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