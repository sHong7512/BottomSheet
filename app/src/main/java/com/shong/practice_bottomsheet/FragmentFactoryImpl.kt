package com.shong.practice_bottomsheet

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory

class FragmentFactoryImpl() : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            BottomSheetFragment::class.java.name -> BottomSheetFragment()
            else -> super.instantiate(classLoader, className)
        }
    }
}