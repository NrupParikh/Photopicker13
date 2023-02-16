package com.specindia.picker13.ui.fragment.tabs

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.rajat.pdfviewer.PdfViewerActivity
import com.specindia.picker13.databinding.FragmentTab9Binding
import com.specindia.picker13.utils.transformations.Util


class Tab9Fragment : Fragment() {
    private lateinit var binding: FragmentTab9Binding
    private var documentPick: ActivityResultLauncher<Array<String>>? = null
    private lateinit var docUri: Uri
    private var realPath: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        documentPick =
            registerForActivityResult(ActivityResultContracts.OpenDocument()) { result ->
                // do something
                Log.d("TAG", "DATA $result")
                binding.tvPath.text = result.toString()
                docUri = result!!

                realPath = Util.getRealPathFromURI(docUri, requireContext())
                if (realPath != null) {
                    binding.tvRealPath.visibility = View.VISIBLE
                    binding.tvRealPath.text = realPath.toString()
                    Log.d("TAG realPath", realPath!!)
                } else {
                    binding.tvRealPath.visibility = View.GONE
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTab9Binding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPickPDF.setOnClickListener {
            documentPick?.launch(
//                arrayOf(
//                    "application/pdf",
//                    "application/msword",
//                    "application/ms-doc",
//                    "application/doc",
//                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document",
//                    "text/plain"
//                )
                arrayOf(
                    "application/pdf"
                )
            )
        }

        binding.btnOpenIntent.setOnClickListener {
            realPath.let {
                val intent = Intent()
                intent.action = Intent.ACTION_VIEW
                intent.setDataAndType(Uri.parse(it), "application/pdf")
                context?.startActivity(intent)
            }
        }
        binding.btnLoadUri.setOnClickListener {
            startActivity(
                PdfViewerActivity.launchPdfFromPath(
                    context = requireContext(),
                    path = realPath,
                    pdfTitle = "PDF from Local Path",
                    directoryName = "",
                    enableDownload = false
                )
            )

        }

        binding.btnLoadUrl.setOnClickListener {
            startActivity(
                PdfViewerActivity.launchPdfFromUrl(
                    context = requireContext(),
                    pdfUrl = "https://www.orimi.com/pdf-test.pdf",
                    pdfTitle = "PDF from URL",
                    directoryName = "",
                    enableDownload = true
                )
            )
        }
    }

}
