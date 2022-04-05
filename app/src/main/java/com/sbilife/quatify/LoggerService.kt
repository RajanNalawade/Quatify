package com.sbilife.quatify

import android.util.Log.d
import javax.inject.Inject

class LoggerService @Inject constructor() {

    fun logService(strMsg: String) = d(TAG, strMsg)
}