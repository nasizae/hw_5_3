package com.example.hw_5_3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw_5_3.databinding.ActivityMainBinding
import com.example.hw_5_3.databinding.FragmentNumBinding
import kotlin.math.log

class NumFragment : Fragment() {

    private lateinit var binding: FragmentNumBinding
    private var num=0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentNumBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
           btnOne.setOnClickListener {
              num++
               zero.text = num.toString()
               if(zero.text.toString().equals("10")){
                   btnOne.text="-1"
                   btnOne.setOnClickListener{
                       num--
                       zero.text=num.toString()
                       if(zero.text.toString().equals("0")){
                           val bundle=Bundle()
                           bundle.putString("result",zero.text.toString())
                           val resultFragment=ResultFragment()
                           resultFragment.arguments=bundle
                           requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container,resultFragment).commit()
                           Log.d( "Emil",zero.text.toString())
                       }
                   }
               }

           }


        }
    }
}