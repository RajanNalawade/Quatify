package com.sbilife.quatify

import android.content.Context
import android.util.Log.d
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import javax.inject.Inject

const val TAG = "QuoteRepo"

interface QuoteRepo {
    fun saveQuote(strQuote: String)

    fun getAllQuote(mContext: Context): MutableList<String>
}

class SQLRepo @Inject constructor() : QuoteRepo {

    override fun saveQuote(strQuote: String) {
        d(TAG, strQuote)
    }

    override fun getAllQuote(mContext: Context): MutableList<String> {
        val quotes: MutableList<String> = mutableListOf()
        var bufferReader: BufferedReader? = null

        try {
            bufferReader = BufferedReader(
                InputStreamReader(
                    mContext.assets.open("all_quotes.txt"),
                    "UTF-8"
                )
            )
            var line: String?
            while ((bufferReader.readLine()
                    .also { line = it }) != null
            ) line?.let { quotes.add(it) }
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            bufferReader?.close()
        }
        return quotes
    }
}

class FirebaseRepo : QuoteRepo {

    override fun saveQuote(strQuote: String) {
        d(TAG, strQuote)
    }

    override fun getAllQuote(mContext: Context): MutableList<String> {
        val quotes: MutableList<String> = mutableListOf()
        var bufferReader: BufferedReader? = null

        try {
            bufferReader = BufferedReader(
                InputStreamReader(
                    mContext.assets.open("all_quotes.txt"),
                    "UTF-8"
                )
            )
            var line: String?
            while ((bufferReader.readLine()
                    .also { line = it }) != null
            ) line?.let { quotes.add(it) }
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            bufferReader?.close()
        }
        return quotes
    }
}