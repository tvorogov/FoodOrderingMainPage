package com.tvorogov.feature_main.ui.menulist


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvorogov.core_data.Repository
import com.tvorogov.core_data.models.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {



    private val productLiveData = MutableLiveData<List<Product>>()
    val proudcts: LiveData<List<Product>> = productLiveData

    init {
        viewModelScope.launch {
            productLiveData.value = repository.getProductsByBreadcrumbs("pizza")
            productLiveData.value = repository.getProductsByBreadcrumbs("desserts")

        }


    }




}