package com.specindia.picker13.ui.fragment.tabs

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.decode.VideoFrameDecoder
import coil.load
import coil.request.ImageRequest
import coil.request.videoFrameMillis
import coil.transform.CircleCropTransformation
import coil.transform.RoundedCornersTransformation
import com.specindia.picker13.R
import com.specindia.picker13.databinding.FragmentTab7Binding
import com.specindia.picker13.utils.transformations.*

class Tab7Fragment : Fragment() {
    private lateinit var binding: FragmentTab7Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTab7Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(RoundedCornersTransformation(100f))
            }
        }

        binding.btn2.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(CircleCropTransformation())
            }
        }

        binding.btn3.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(BlurTransformation(requireContext()), CircleCropTransformation())
            }
        }

        binding.btn4.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(GrayscaleTransformation(), CircleCropTransformation())
            }
        }

        binding.btn5.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(CropTransformation(CropTransformation.CropType.TOP))
            }
        }

        binding.btn6.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(SquareCropTransformation())
            }
        }

        binding.btn7.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            binding.iv1.load("https://picsum.photos/300") {
                crossfade(true)
                crossfade(1000)
                placeholder(R.drawable.ic_image)
                transformations(
                    MaskTransformation(
                        requireContext(),
                        R.drawable.ic_baseline_two_wheeler_24
                    ),
                )
            }
        }

        // https://github.com/coil-kt/coil/issues/413
        // https://gist.github.com/jsturgis/3b19447b304616f18657

        binding.btn8.setOnClickListener {
            binding.iv1.visibility = View.VISIBLE
            binding.rlPalette.visibility = View.GONE

            val imageLoader = ImageLoader.Builder(requireContext())
                .components {
                    add(VideoFrameDecoder.Factory())
                }
                .build()

            val request = ImageRequest.Builder(requireContext())
                .data("https://storage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4")
                //.data("https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4")
                .videoFrameMillis(7000)
                .crossfade(true)
                .crossfade(1000)
                .placeholder(R.drawable.ic_image)
                .target(binding.iv1)
                .build()
            imageLoader.enqueue(request)
        }

        binding.btn9.setOnClickListener {
            binding.rlPalette.visibility = View.VISIBLE
            binding.iv1.load("https://picsum.photos/300") {
                allowHardware(false)
                listener(
                    onSuccess = { _, result ->
                        Palette.Builder(result.drawable.toBitmap()).generate { palette ->
                            // Consume the palette.
                            Log.d("TAG", "Vibrant  ${palette?.vibrantSwatch?.titleTextColor}")
                            Log.d(
                                "TAG",
                                "Vibrant dark ${palette?.darkVibrantSwatch?.titleTextColor}"
                            )
                            Log.d(
                                "TAG",
                                "Vibrant light ${palette?.lightVibrantSwatch?.titleTextColor}"
                            )
                            Log.d("TAG", "Muted  ${palette?.mutedSwatch?.titleTextColor}")
                            Log.d("TAG", "Muted dark ${palette?.darkMutedSwatch?.titleTextColor}")
                            Log.d("TAG", "Muted light ${palette?.lightMutedSwatch?.titleTextColor}")

                            palette?.vibrantSwatch?.rgb?.let { it1 ->
                                binding.p1.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                            palette?.darkVibrantSwatch?.rgb?.let { it1 ->
                                binding.p2.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                            palette?.lightVibrantSwatch?.rgb?.let { it1 ->
                                binding.p3.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                            palette?.mutedSwatch?.rgb?.let { it1 ->
                                binding.p4.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                            palette?.darkMutedSwatch?.rgb?.let { it1 ->
                                binding.p5.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                            palette?.lightMutedSwatch?.rgb?.let { it1 ->
                                binding.p6.setBackgroundColor(
                                    Color.rgb(Color.red(it1),Color.green(it1),Color.blue(it1))
                                )
                            }
                        }
                    }
                )
            }


        }

    }

}
