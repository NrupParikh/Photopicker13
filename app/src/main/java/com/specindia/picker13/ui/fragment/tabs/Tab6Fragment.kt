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
import com.specindia.picker13.databinding.*

class Tab6Fragment : Fragment() {
    private lateinit var binding: FragmentTab6Binding
    private  var pickMultipleMedia: ActivityResultLauncher<PickVisualMediaRequest>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pickMultipleMedia =
            registerForActivityResult(ActivityResultContracts.PickMultipleVisualMedia(maxItems = 2)) { uri ->
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
        binding = FragmentTab6Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPickMultipleImageAndVideos.setOnClickListener {
            pickMultipleMedia?.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageAndVideo))
        }
    }

}
