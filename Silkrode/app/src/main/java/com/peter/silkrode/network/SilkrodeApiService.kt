package com.peter.silkrode.network

import com.peter.silkrode.BuildConfig
import com.peter.silkrode.data.User

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

private const val BASE_URL = "https://api.github.com/"

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val client = OkHttpClient.Builder()
    .addInterceptor(HttpLoggingInterceptor().apply {
        level = when (BuildConfig.LOGGER_VISIABLE) {
            true -> HttpLoggingInterceptor.Level.BODY
            false -> HttpLoggingInterceptor.Level.NONE
        }
    })
    .build()

/**
 * Use the Retrofit builder to build a retrofit object using a Moshi converter with our Moshi
 * object.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .client(client)
    .build()

/**
 * A public interface that exposes the [getNumberValue] and [postTenNumber] methods
 */
interface SilkrodeApiService {

    /**
     * Returns a Coroutine [Deferred] [Process] which can be fetched with await() if in a Coroutine scope.
     * The @GET annotation indicates that the "process" endpoint will be requested with the GET HTTP method
     */

    @GET("users/{name}")
    suspend fun getMyUserDetail(@Path("name")name:String): User

    @GET("users/octocat/followers")
    suspend fun getFollowerList(): List<User>




}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object SilkrodeApi {
    val retrofitService: SilkrodeApiService by lazy { retrofit.create(SilkrodeApiService::class.java) }
}