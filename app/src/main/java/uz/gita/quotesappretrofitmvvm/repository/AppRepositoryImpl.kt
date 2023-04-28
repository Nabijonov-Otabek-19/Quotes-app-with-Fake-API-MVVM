package uz.gita.quotesappretrofitmvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.quotesappretrofitmvvm.api.NetworkManager
import uz.gita.quotesappretrofitmvvm.model.QuoteData

class AppRepositoryImpl : AppRepository {

    private val api = NetworkManager.getApiService()

    override fun getQuotes(): Flow<List<QuoteData>> = flow {
        emit(api.getQuotes())

    }.flowOn(Dispatchers.IO)
}