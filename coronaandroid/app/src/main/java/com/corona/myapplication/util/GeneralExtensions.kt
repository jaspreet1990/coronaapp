package com.corona.myapplication.util

import android.content.Context
import android.widget.Toast

fun Context.longToast(message: String?) {
    if (!message.isNullOrBlank())
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}