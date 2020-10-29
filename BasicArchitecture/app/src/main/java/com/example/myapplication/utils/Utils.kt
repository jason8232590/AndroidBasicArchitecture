package com.example.myapplication.utils

import android.content.res.Resources
import android.renderscript.Sampler
import android.util.TypedValue

class Utils {
    //跟Extensions中得方法 Float.px是一样的功能
    companion object {
        fun dp2px(value: Float): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                Resources.getSystem().displayMetrics
            )
        }
    }
}