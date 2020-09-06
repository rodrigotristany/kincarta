package com.rodrigotristany.kincarta.di.modules

import com.rodrigotristany.kincarta.data.api.ContactsApi
import com.rodrigotristany.kincarta.data.api.ContactsProvider
import com.rodrigotristany.kincarta.domain.repositories.ContactsRepository
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class DataModule{
    companion object {
        private const val BASE_URL: String = "https://s3.amazonaws.com/technical-challenge/v3/"
    }

    @Provides
    @Singleton
    fun provideClient() : OkHttpClient {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return OkHttpClient().newBuilder()
            .addInterceptor(interceptor)
            .addInterceptor { chain ->
                var request : Request = chain.request()
                val url : HttpUrl = request .url().newBuilder().build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(baseUrl: String, client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideContactsApi() : ContactsApi {
        return provideRetrofit(BASE_URL, provideClient()).create(ContactsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideContactsRepository() : ContactsRepository {
        return ContactsProvider(provideContactsApi())
    }
}