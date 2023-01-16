package com.specindia.picker13.ui.fragment.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.specindia.picker13.databinding.FragmentTab2Binding
import com.specindia.picker13.databinding.FragmentTab3Binding
import com.specindia.picker13.databinding.FragmentTab4Binding
import com.specindia.picker13.databinding.FragmentTab5Binding

class Tab5Fragment : Fragment() {
    private lateinit var binding: FragmentTab5Binding
    private  var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickMedia =
            registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
                if (uri != null) {
                    binding.tvPath.text = uri.toString()
                } else {
                    Toast.makeText(requireActivity(), "No media selected", Toast.LENGTH_SHORT).show()
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTab5Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnPickImageOrVideo.setOnClickListener {
            pickMedia?.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
            }
    }

}
