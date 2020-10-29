package com.example.myapplication.utils

import android.content.res.Resources
import android.util.TypedValue

//可以看成给float加了一个属性  直接写100.px
val Float.px
get() = TypedValue.applyDimension(
    TypedValue.COMPLEX_UNIT_DIP,
    this,
    Resources.getSystem().displayMetrics)