package uz.gita.quotesappretrofitmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import uz.gita.quotesappretrofitmvvm.model.QuoteData
import uz.gita.quotesappretrofitmvvm.repository.AppRepositoryImpl

class MainViewModel : ViewModel() {

    private val repository = AppRepositoryImpl()

    val errorData = MutableLiveData<String>()
    val quotesData = MutableLiveData<List<QuoteData>>()

    fun getQuotes() {
        viewModelScope.launch {
            repository.getQuotes().collect {
                quotesData.value = it
            }
        }
    }
}