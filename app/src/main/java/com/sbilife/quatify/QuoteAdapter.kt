package com.sbilife.quatify

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sbilife.quatify.databinding.ListItemQuoteBinding

class QuoteAdapter(private val listQuote: List<String>) :
    RecyclerView.Adapter<QuoteAdapter.QuoteViewHolder>() {

    // create an inner class with name ViewHolder
    // It takes a view argument, in which pass the generated class of list_item_quote.xml
    // i.e. ListItemQuoteBinding and in the RecyclerView.ViewHolder(binding.root) pass it like this
    inner class QuoteViewHolder(val binding: ListItemQuoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    // inside the onCreateViewHolder inflate the view of SingleItemBinding
    // and return new ViewHolder object containing this layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteViewHolder {
        val binding = ListItemQuoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return QuoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuoteViewHolder, position: Int) {

        val colors = listOf("#448AFF", "#FFC107", "#009688", "#E91E63", "#FF5722")

        with(holder) {
            with(listQuote.get(position)) {
                binding.textView.text = this
                val color = position % colors.size
                binding.mainCardView.setBackgroundColor(Color.parseColor(colors.get(color)))
            }
        }
    }

    override fun getItemCount(): Int = listQuote.size

}