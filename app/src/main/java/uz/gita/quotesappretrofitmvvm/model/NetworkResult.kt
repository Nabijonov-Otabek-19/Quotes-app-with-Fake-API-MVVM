package uz.gita.quotesappretrofitmvvm.model

import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<T : Any?> {
    class SuccessApi<T : Any>(val data: T) : NetworkResult<T>()
    class FailureApi<T : Any>(val code: Int, val message: String?) : NetworkResult<T>()
    class ExceptionApi<T : Any>(val exception: Throwable) : NetworkResult<T>()
}


suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.SuccessApi(body)
        } else {
            NetworkResult.FailureApi(response.code(), response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.FailureApi(e.code(), e.message)
    } catch (e: Throwable) {
        NetworkResult.ExceptionApi(e)
    }
}