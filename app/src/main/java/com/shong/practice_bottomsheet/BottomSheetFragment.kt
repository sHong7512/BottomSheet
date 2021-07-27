package com.shong.practice_bottomsheet

import android.app.Dialog
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment  : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.dialog_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dialog?.apply {
            findViewById<TextView>(R.id.dialogText1)!!.setOnClickListener {
                Toast.makeText(requireContext(), "Text One is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
            findViewById<TextView>(R.id.dialogText2)!!.setOnClickListener {
                Toast.makeText(requireContext(), "Text two is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
            findViewById<TextView>(R.id.dialogText3)!!.setOnClickListener {
                Toast.makeText(requireContext(), "Text three is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
        }?.show()
    }



}