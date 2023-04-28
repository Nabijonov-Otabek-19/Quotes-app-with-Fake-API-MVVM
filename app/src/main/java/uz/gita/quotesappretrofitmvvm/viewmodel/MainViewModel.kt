package uz.gita.quotesappretrofitmvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import uz.gita.quotesappretrofitmvvm.model.NetworkResult
import uz.gita.quotesappretrofitmvvm.model.QuoteData
import uz.gita.quotesappretrofitmvvm.repository.AppRepositoryImpl

class MainViewModel : ViewModel() {

    private val repository = AppRepositoryImpl()

    val errorData = MutableLiveData<String>()
    val quotesData = MutableLiveData<List<QuoteData>>()

    fun getQuotes() {
        viewModelScope.launch {
            repository.getQuotes().collect {
                when (it) {
                    is NetworkResult.SuccessApi -> {
                        quotesData.value = it.data
                    }

                    is NetworkResult.FailureApi -> {
                        errorData.value = "FailureAPi + ${it.message ?: it.code}"
                    }

                    is NetworkResult.ExceptionApi -> {
                        errorData.value = "ExceptionApi + ${it.exception.message}"
                    }
                }
            }
        }
    }
}