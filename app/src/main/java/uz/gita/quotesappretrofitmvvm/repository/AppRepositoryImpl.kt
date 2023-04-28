package uz.gita.quotesappretrofitmvvm.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.gita.quotesappretrofitmvvm.api.NetworkManager
import uz.gita.quotesappretrofitmvvm.model.NetworkResult
import uz.gita.quotesappretrofitmvvm.model.QuoteData
import uz.gita.quotesappretrofitmvvm.model.handleApi

class AppRepositoryImpl : AppRepository {

    private val api = NetworkManager.getApiService()

    override fun getQuotes(): Flow<NetworkResult<List<QuoteData>>> = flow {
        val networkResult = handleApi {
            api.getQuotes()
        }
        emit(networkResult)

    }.flowOn(Dispatchers.IO)
}