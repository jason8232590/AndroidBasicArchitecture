package com.example.myapplication.slidemenuactivity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R


class CustomViewActivity : AppCompatActivity() {
    lateinit var smv_slidemenu: SlideMenuView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom_view)
        smv_slidemenu = findViewById<View>(R.id.sm) as SlideMenuView
    }


    fun tabClick(view: View) {
        val tv = view as TextView
        Toast.makeText(this, "" + tv.text, Toast.LENGTH_SHORT).show()
        if (smv_slidemenu.isLeftOpen()) {
            //如果是开着的就关闭
            smv_slidemenu.closeLeft()
        }
    }

    fun openLeft(view: View?) {
        if (smv_slidemenu.isLeftOpen()) {
            //如果是开着的就关闭
            smv_slidemenu.closeLeft()
        } else {
            smv_slidemenu.openLeft()
        }
    }
}