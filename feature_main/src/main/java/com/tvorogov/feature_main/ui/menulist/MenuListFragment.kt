package com.tvorogov.feature_main.ui.menulist

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.tvorogov.core_data.models.Product
import com.tvorogov.feature_main.R
import com.tvorogov.feature_main.databinding.FragmentMenuListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuListFragment : Fragment(R.layout.fragment_menu_list),
    ProductsAdapter.OnItemClickListener {


    private val viewModel: MenuListViewModel by viewModels()

    private val binding: FragmentMenuListBinding by viewBinding()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setupBanners()
        setupProductAdapter()
        setupChips()




    }


    private fun setupProductAdapter(){
        val listAdapter = ProductsAdapter(this)

        binding.apply {
            recyclerViewProducts.apply {
                adapter = listAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }

        viewModel.proudcts.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }
    }



    private fun setupBanners() {
        val bannersAdapter = BannersAdapter(
            listOf(
                R.drawable.banner1,
                R.drawable.banner2,
                R.drawable.banner3,
                R.drawable.banner4,
                R.drawable.banner5,
                R.drawable.banner6
            )
        )
        binding.apply {
            recyclerViewBanners.apply {
                adapter = bannersAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }
        }
    }

    private fun setupChips(){

        val chipsAdapter = ChipsAdapter(
            listOf(
                "Pizza",
                "Combo",
                "Desserts",
                "Drinks",
                "Another"
            )
        )
        binding.apply {
            recyclerViewChips.apply {
                adapter = chipsAdapter
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                setHasFixedSize(true)
            }
        }
    }


    override fun onItemClick(product: Product) {
//        TODO("Not yet implemented")
    }
}