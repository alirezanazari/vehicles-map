package ir.alirezanazari.vehicles.internal

import android.content.Context
import android.util.Log
import android.widget.Toast
import ir.alirezanazari.vehicles.BuildConfig


class Logger {

    companion object {

        fun showToast(context: Context?, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun showToast(context: Context?, message: Int) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun showLog(text: String?) {
            if (BuildConfig.DEBUG) Log.wtf("Vehicles Log", text)
        }
    }
}