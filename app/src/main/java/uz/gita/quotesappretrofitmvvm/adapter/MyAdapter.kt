package uz.gita.quotesappretrofitmvvm.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.gita.quotesappretrofitmvvm.databinding.ItemQuoteBinding
import uz.gita.quotesappretrofitmvvm.model.QuoteData

class MyAdapter : Adapter<MyAdapter.ItemHolder>() {

    private val quotesList = ArrayList<QuoteData>()

    fun setDataList(list: List<QuoteData>) {
        quotesList.clear()
        quotesList.addAll(list)
    }

    inner class ItemHolder(private val binding: ItemQuoteBinding) : ViewHolder(binding.root) {

        fun bind() {
            binding.apply {
                txtAuthor.text = quotesList[adapterPosition].author
                txtQuote.text = quotesList[adapterPosition].text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            ItemQuoteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = quotesList.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind()
    }
}