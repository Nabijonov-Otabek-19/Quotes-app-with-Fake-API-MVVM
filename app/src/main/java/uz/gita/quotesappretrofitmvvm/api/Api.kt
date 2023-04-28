package uz.gita.quotesappretrofitmvvm.api

import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import uz.gita.quotesappretrofitmvvm.model.QuoteData

interface Api {
    @GET("quotes")
    suspend fun getQuotes(): List<QuoteData>
}