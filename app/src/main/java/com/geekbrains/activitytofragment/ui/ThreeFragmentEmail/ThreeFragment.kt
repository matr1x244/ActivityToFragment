package com.geekbrains.activitytofragment.ui.ThreeFragmentEmail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.geekbrains.activitytofragment.databinding.FragmentThreeBinding

class ThreeFragment : Fragment() {

    companion object {
        fun newInstance() = ThreeFragment()
    }

    private var _binding: FragmentThreeBinding? = null
    private val binding get() = _binding!!

    private val emailValidator = EmailValidator()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentThreeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startEmail()
    }

    private fun startEmail() {
        binding.emailInput.addTextChangedListener(emailValidator)

        binding.testingButtonEmail.setOnClickListener {
            if (emailValidator.isValid) {
                Toast.makeText(activity, "Успешно", Toast.LENGTH_SHORT).show()
            } else {
                val errorEmail = "Не верный email"
                binding.emailInput.error = errorEmail
                Toast.makeText(context, errorEmail, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}