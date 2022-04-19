package com.geekbrains.activitytofragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.geekbrains.activitytofragment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    companion object {
        fun newInstance() = FirstFragment()
    }

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonFirst()
    }

    private fun buttonFirst() {
        binding.buttonFirst.setOnClickListener {
            activity?.supportFragmentManager?.let { fragment ->
                fragment.beginTransaction()
                    .replace(R.id.container_main_activity, SecondFragment.newInstance())
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}