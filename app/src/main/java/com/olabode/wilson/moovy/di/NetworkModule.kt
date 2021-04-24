package com.olabode.wilson.moovy.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.olabode.wilson.moovy.BuildConfig
import com.olabode.wilson.moovy.api.DiscoverService
import com.olabode.wilson.moovy.api.MovieService
import com.olabode.wilson.moovy.api.RequestInterceptor
import com.olabode.wilson.moovy.api.SearchService
import com.olabode.wilson.moovy.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @Singleton
    fun provideHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.NONE
            else HttpLoggingInterceptor.Level.NONE

        return OkHttpClient.Builder()
            .addInterceptor(RequestInterceptor())
            .addInterceptor(logging)
            .build()
    }


    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitBuilder(gsonBuilder: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
    }


    @Singleton
    @Provides
    fun provideDiscoverService(retrofitBuilder: Retrofit.Builder): DiscoverService {
        return retrofitBuilder
            .build()
            .create(DiscoverService::class.java)
    }

    @Singleton
    @Provides
    fun provideSearchService(retrofitBuilder: Retrofit.Builder): SearchService {
        return retrofitBuilder
            .build()
            .create(SearchService::class.java)
    }

    @Singleton
    @Provides
    fun provideMovieService(retrofitBuilder: Retrofit.Builder): MovieService {
        return retrofitBuilder
            .build()
            .create(MovieService::class.java)
    }
}