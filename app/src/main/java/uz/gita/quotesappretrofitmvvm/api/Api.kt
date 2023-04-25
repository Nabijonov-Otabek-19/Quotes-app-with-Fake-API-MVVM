package uz.gita.quotesappretrofitmvvm.api

import retrofit2.Call
import retrofit2.http.GET
import uz.gita.quotesappretrofitmvvm.model.QuoteData

interface Api {
    @GET("quotes")
    fun getQuotes(): Call<List<QuoteData>>
}