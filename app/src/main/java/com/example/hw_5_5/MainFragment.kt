package com.example.hw_5_5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.hw_5_5.databinding.FragmentMainBinding
import com.example.hw_5_5.utils.loadImage

class MainFragment : Fragment() {
    private lateinit var binding : FragmentMainBinding
    private val viewModel: LoveViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loveImage.loadImage("https://www.logos.com/grow/wp-content/uploads/2023/02/WxW-Love.png")
        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            btnCalculate.setOnClickListener {
                viewModel.getLiveLoveData(etFirst.text.toString(), etSecond.text.toString())
                    .observe(viewLifecycleOwner, Observer {
                        tvResult.text = it.percentage
                    })
            }
        }
    }
}