package com.me.bui.hikotlin

import android.graphics.Color
import java.util.*

object Utils {
    fun randomColor(): Int {
        val rnd: Random = Random()
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
    }
}