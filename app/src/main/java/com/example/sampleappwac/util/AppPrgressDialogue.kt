package com.example.sampleappwac.util


import android.app.ProgressDialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.SparseBooleanArray
import androidx.core.util.forEach
import androidx.core.util.set
import com.example.sampleappwac.R


class AppProgressDialogue(context: Context) : ProgressDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.progress_bar)
        window?.setBackgroundDrawable(ColorDrawable(0))
        window?.setDimAmount(0.0f)
    }

    val sparseArray = SparseBooleanArray()


    override fun show() {
        try {
            super.show()
        } catch (e: Exception) {
        }
    }

    override fun dismiss() {
        try {
            super.dismiss()
        } catch (e: Exception) {
        }
    }

    fun show(key: Int) {
        sparseArray[key] = true
        show()
    }

    fun dismiss(key: Int) {
        sparseArray[key] = false
        sparseArray.forEach { key, value ->
            if (value) return
        }
        dismiss()
    }
}