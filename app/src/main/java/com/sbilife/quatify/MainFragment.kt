package com.sbilife.quatify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sbilife.quatify.custom_qualifiers.FirebaseQualifier
import com.sbilife.quatify.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    @Inject
    //to avoid typo in @Named() annotation use custom qualifiers
    @FirebaseQualifier
    lateinit var mQuoteRepo: QuoteRepo

    private var _binding: FragmentMainBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        _binding!!.imageView2.setOnClickListener {
            mQuoteRepo.saveQuote("data saved!")
        }

        _binding!!.textView2.setOnClickListener {
            mQuoteRepo.saveQuote("data saved!")
        }

        return _binding!!.root
    }
}