package com.specindia.picker13.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.media3.common.util.UnstableApi
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.google.android.material.tabs.TabLayoutMediator
import com.specindia.picker13.databinding.FragmentMainBinding
import com.specindia.picker13.ui.activity.MainActivity
import com.specindia.picker13.ui.adapter.MyViewPagerAdapter
import com.specindia.picker13.ui.fragment.tabs.*

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    @UnstableApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setUpButtonClick(view)


        val adapter = MyViewPagerAdapter((activity as MainActivity))
        adapter.apply {
            addFragment(Tab8Fragment(), "Exoplayer")
            addFragment(Tab1Fragment(), "Only Image")
            addFragment(Tab2Fragment(), "Only Video")
            addFragment(Tab3Fragment(), "Multiple Images")
            addFragment(Tab4Fragment(), "Multiple Videos")
            addFragment(Tab5Fragment(), "Image or Video")
            addFragment(Tab6Fragment(), "Images and Videos")
            addFragment(Tab7Fragment(), "Coil")

        }

        binding.apply {
            viewPager.adapter = adapter
            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                tab.text = adapter.getTabTitle(position)
            }.attach()

            viewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    Log.d("TAG", "Selected page is $position")
                    Toast.makeText(requireContext(), "Page $position", Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}
