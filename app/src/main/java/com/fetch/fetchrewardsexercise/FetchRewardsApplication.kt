package com.fetch.fetchrewardsexercise

import android.app.Application
import com.fetch.fetchrewardsexercise.di.fetchDataModule
import com.fetch.fetchrewardsexercise.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FetchRewardsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FetchRewardsApplication)
            modules(
                viewModelModule,
                fetchDataModule
            )
        }
    }

}