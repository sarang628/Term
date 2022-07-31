package com.example.screen_terms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import com.example.screen_terms.databinding.BlankFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlankFragment : Fragment() {
    lateinit var blankFragmentBinding: BlankFragmentBinding

    var navigationNext = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        blankFragmentBinding = BlankFragmentBinding.inflate(layoutInflater, container, false)

        blankFragmentBinding.wv.loadUrl("http://sarang628.iptime.org:90/agreement.html")

        if (navigationNext != -1)
            NavHostFragment.findNavController(this).navigate(navigationNext)

        val activity = requireActivity()

        blankFragmentBinding.btn1.setOnClickListener {
            if (activity is BlankFragmentInterAction) {
                activity.disAgree()
            }
        }

        blankFragmentBinding.button.setOnClickListener {
            if (activity is BlankFragmentInterAction) {
                activity.agree()
            }
        }


        return blankFragmentBinding.root
    }


    interface BlankFragmentInterAction {
        fun agree()
        fun disAgree()
    }
}