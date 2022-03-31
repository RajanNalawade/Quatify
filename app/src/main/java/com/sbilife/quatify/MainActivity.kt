package com.sbilife.quatify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sbilife.quatify.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    // view binding for the activity
    private var _binding: ActivityMainBinding? = null

    //not null asserted operator (!!) executes function even name is null
    // throws error if name is null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listOfQoate.layoutManager = LinearLayoutManager(this)

        binding.listOfQoate.adapter = QuoteAdapter(getAllQuote())
    }

    private fun getAllQuote(): MutableList<String> {
        val quotes: MutableList<String> = mutableListOf()
        var bufferReader: BufferedReader? = null

        try {
            bufferReader = BufferedReader(
                InputStreamReader(
                    this.assets.open("all_quotes.txt"),
                    "UTF-8"
                )
            )
            var line: String?
            while ((bufferReader.readLine().also { line = it }) != null) line?.let { quotes.add(it) }
        } catch (ex: IOException) {
            ex.printStackTrace()
        } finally {
            if (bufferReader != null) {
                bufferReader.close()
            }
        }
        return quotes
    }


}