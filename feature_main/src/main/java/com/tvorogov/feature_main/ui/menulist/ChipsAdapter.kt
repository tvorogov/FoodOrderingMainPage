package com.tvorogov.feature_main.ui.menulist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tvorogov.feature_main.databinding.ItemChipBinding

class ChipsAdapter(private val someString: List<String>) : RecyclerView.Adapter<ChipsAdapter.ChipsViewHolder>() {

    class ChipsViewHolder(private val binding: ItemChipBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String){
            binding.btnChip.text = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChipsViewHolder {

        val binding = ItemChipBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ChipsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChipsViewHolder, position: Int) {
        val currentItem = someString[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return someString.size
    }
}