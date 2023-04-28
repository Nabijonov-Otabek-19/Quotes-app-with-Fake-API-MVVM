package uz.gita.quotesappretrofitmvvm.api

import retrofit2.Response
import retrofit2.http.GET
import uz.gita.quotesappretrofitmvvm.model.QuoteData

interface Api {
    @GET("quotes")
    suspend fun getQuotes(): Response<List<QuoteData>>
}