package com.aman.filedownloading

import android.content.Context
import android.widget.Toast

class Extensions {
}

/**
 * Toast
 * simple extension function to display toast
 *
 * @param msg
 * @param duration
 */
fun Context.toast(msg: String = "", duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, msg, duration).show()
}
