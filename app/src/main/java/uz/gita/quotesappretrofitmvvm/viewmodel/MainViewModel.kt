package uz.gita.quotesappretrofitmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import uz.gita.quotesappretrofitmvvm.model.QuoteData
import uz.gita.quotesappretrofitmvvm.repository.AppRepository

class MainViewModel : ViewModel() {

    private val repository = AppRepository()

    val errorData = MutableLiveData<String>()
    val quotesData = MutableLiveData<List<QuoteData>>()

    fun getQuotes() {
        repository.getQuotes(errorData, quotesData)
    }
}