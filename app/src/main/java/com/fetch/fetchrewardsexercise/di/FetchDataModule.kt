package com.fetch.fetchrewardsexercise.di

import com.fetch.fetchrewardsexercise.BuildConfig
import com.fetch.fetchrewardsexercise.data.remote.FetchAPI
import com.fetch.fetchrewardsexercise.domain.repository.FetchRepository
import com.fetch.fetchrewardsexercise.data.repository.FetchRepositoryImpl
import com.fetch.fetchrewardsexercise.domain.util.ConnectivityChecker
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val fetchDataModule = module {

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(FetchAPI::class.java) }

    single { ConnectivityChecker(androidContext()) }

    singleOf(::FetchRepositoryImpl).bind<FetchRepository>()
}
