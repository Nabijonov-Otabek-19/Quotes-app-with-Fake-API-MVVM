package uz.gita.quotesappretrofitmvvm.repository

import kotlinx.coroutines.flow.Flow
import uz.gita.quotesappretrofitmvvm.model.QuoteData

interface AppRepository {

    fun getQuotes(): Flow<List<QuoteData>>
}