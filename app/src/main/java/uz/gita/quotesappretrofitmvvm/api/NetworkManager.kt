package uz.gita.quotesappretrofitmvvm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkManager {

    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://type.fit/api/"

    private var api: Api? = null

    fun getApiService(): Api {
        if (api == null) {
            retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL).build()

            api = retrofit!!.create(Api::class.java)
        }
        return api!!
    }
}