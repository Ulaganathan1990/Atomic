package com.example.atomic.view.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.atomic.model.Sport
import com.example.atomic.repo.ContentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: ContentRepository
) : ViewModel() {

    private val cryptocurrencyEmitter = MutableLiveData<List<Sport>>()
    val cryptoCurrency: LiveData<List<Sport>> = cryptocurrencyEmitter

    init {
        loadCryptocurrency()
    }

    // getting cryptocurrencies list using
    // repository and passing it into live data
    private fun loadCryptocurrency() {

        GlobalScope.launch(Dispatchers.Main) {
            cryptocurrencyEmitter.value = repository.getFeaturedSports()
        }
    }
}