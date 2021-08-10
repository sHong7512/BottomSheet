package com.shong.practice_bottomsheet

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private val bottomSheetBehavior: BottomSheetBehavior<View> by lazy {
        BottomSheetBehavior.from(
            findViewById(R.id.bottom_sheet_layout)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = FragmentFactoryImpl()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            showBottomSheetDialog()
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            val bottomSheet = BottomSheetFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        findViewById<Button>(R.id.button3).setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        makeBottomSheetBehavior()

    }

    private fun showBottomSheetDialog(){
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(R.layout.dialog_bottom_sheet)

        bottomSheetDialog.apply {
            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            findViewById<TextView>(R.id.dialogText1)!!.setOnClickListener {
                Toast.makeText(applicationContext, "Text One is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
            findViewById<TextView>(R.id.dialogText2)!!.setOnClickListener {
                Toast.makeText(applicationContext, "Text two is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
            findViewById<TextView>(R.id.dialogText3)!!.setOnClickListener {
                Toast.makeText(applicationContext, "Text three is Clicked ", Toast.LENGTH_SHORT).show()
                this.dismiss()
            }
        }?.show()

    }

    private fun makeBottomSheetBehavior(){

        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                //Log.d("_sHong", "slide ${slideOffset}")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState) {
                    BottomSheetBehavior.STATE_COLLAPSED-> {
                        Toast.makeText(applicationContext,"최소화", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_DRAGGING-> {
//                        Toast.makeText(applicationContext,"드래그",Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_EXPANDED-> {
                        Toast.makeText(applicationContext,"확장", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_HIDDEN-> {
                        Toast.makeText(applicationContext,"숨기기", Toast.LENGTH_SHORT).show()
                    }
                    BottomSheetBehavior.STATE_SETTLING-> {
//                        Toast.makeText(applicationContext,"세틀",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        bottomSheetBehavior.setGestureInsetBottomIgnored(true)
    }
}