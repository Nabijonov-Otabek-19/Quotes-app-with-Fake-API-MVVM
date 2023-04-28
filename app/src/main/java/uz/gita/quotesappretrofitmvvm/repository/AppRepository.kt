package uz.gita.quotesappretrofitmvvm.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.quotesappretrofitmvvm.model.NetworkResult
import uz.gita.quotesappretrofitmvvm.model.QuoteData

interface AppRepository {
    fun getQuotes(): Flow<NetworkResult<List<QuoteData>>>
}