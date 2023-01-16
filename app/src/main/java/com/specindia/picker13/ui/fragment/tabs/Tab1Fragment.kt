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
import androidx.lifecycle.lifecycleScope
import com.specindia.picker13.databinding.FragmentTab1Binding
import kotlinx.coroutines.launch


class Tab1Fragment : Fragment() {
    private lateinit var binding: FragmentTab1Binding
    private var pickMedia: ActivityResultLauncher<PickVisualMediaRequest>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                binding.tvPath.visibility = View.VISIBLE
                binding.tvPath.text = uri.toString()
                lifecycleScope.launch {
                    binding.imageView.setImageURI(uri)
                }
            } else {
                binding.tvPath.visibility = View.GONE
                Toast.makeText(requireActivity(), "No media selected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTab1Binding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPickOnlyImage.setOnClickListener {
            pickMedia?.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
    }

}
