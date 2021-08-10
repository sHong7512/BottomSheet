package com.shong.practice_bottomsheet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * @author sHong
 * You must refer to the changed part of the theme
 */
class BottomSheetFragment  : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return inflater.inflate(R.layout.fragment_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val parentView = view.parent as FrameLayout

        val bottomSheetBehavior: BottomSheetBehavior<View> = BottomSheetBehavior.from(parentView)
        bottomSheetBehavior.skipCollapsed = true
        bottomSheetBehavior.peekHeight = 0

        CoroutineScope(Dispatchers.Main).launch {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        val lp = parentView.layoutParams as CoordinatorLayout.LayoutParams
        lp.height = 1800
        parentView.setLayoutParams(lp)

        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

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