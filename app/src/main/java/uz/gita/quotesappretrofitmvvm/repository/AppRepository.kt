package uz.gita.quotesappretrofitmvvm.repository

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.gita.quotesappretrofitmvvm.api.NetworkManager
import uz.gita.quotesappretrofitmvvm.model.QuoteData

class AppRepository {

    fun getQuotes(
        error: MutableLiveData<String>,
        quotes: MutableLiveData<List<QuoteData>>
    ) {

        NetworkManager.getApiService().getQuotes()
            .enqueue(object : Callback<List<QuoteData>?> {
                override fun onResponse(
                    call: Call<List<QuoteData>?>,
                    response: Response<List<QuoteData>?>
                ) {
                    if (response.isSuccessful) {
                        quotes.value = response.body()
                    }
                }

                override fun onFailure(call: Call<List<QuoteData>?>, t: Throwable) {
                    error.value = t.localizedMessage
                }
            })
    }
}