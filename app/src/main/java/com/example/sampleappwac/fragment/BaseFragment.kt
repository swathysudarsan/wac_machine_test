package com.example.sampleappwac.fragment

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import com.example.sampleappwac.util.AppProgressDialogue
import com.example.sampleappwac.viewModel.BaseViewModel

open class BaseFragment:Fragment() {
    open val viewModel: BaseViewModel by lazy { BaseViewModel() }


    open var finishOnBack = false
    open var bottomNavigationIndex = -1
    lateinit var progressDialog: AppProgressDialogue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        progressDialog = AppProgressDialogue(requireContext())


    }

    override fun onStart() {
        super.onStart()

        viewModel.showLoader.observe(viewLifecycleOwner) {
            if (it)
                progressDialog.show()
            else
                progressDialog.dismiss()
        }

    }

    override fun onResume() {
        super.onResume()
        println("SCREEN_NAME ${this.javaClass.simpleName}")
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (finishOnBack)
            requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
                isEnabled = false
                requireActivity().finish()
            }


    }
}