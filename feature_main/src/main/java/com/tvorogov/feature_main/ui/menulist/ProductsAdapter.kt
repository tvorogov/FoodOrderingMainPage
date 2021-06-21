package com.tvorogov.feature_main.ui.menulist

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tvorogov.core_data.models.Product
import com.tvorogov.feature_main.R
import com.tvorogov.feature_main.databinding.ItemProductBinding


class ProductsAdapter(
    private val listener: OnItemClickListener
) : ListAdapter<Product, ProductsAdapter.ProductViewHolder>(DiffCallback()) {

    interface OnItemClickListener {
        fun onItemClick(product: Product)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {

        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val currentItem = getItem(position)

        holder.bind(currentItem)
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(product: Product) {

            binding.apply {
                textViewName.text = product.title
                textViewDescription.text = product.ingredientList
                val price = product.price.toString()
                btnPurchase.text = "от $price руб"
                Glide.with(itemView)
                    .load(product.images)
                    .centerCrop()
                    .error(R.drawable.ic_qr_scan)
                    .into(imageProduct)

            }

        }

        init {

            binding.apply {
                btnPurchase.setOnClickListener {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val note = getItem(position)
                        listener.onItemClick(note)
                    }
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            Log.d("zxc", "areItemsTheSame: ")
            return oldItem.id == newItem.id

        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            Log.d("zxc", "areContentsTheSame: ")

            return oldItem == newItem
        }
    }


}