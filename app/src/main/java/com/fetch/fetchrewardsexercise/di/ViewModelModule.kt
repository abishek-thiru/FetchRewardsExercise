package com.fetch.fetchrewardsexercise.di

import com.fetch.fetchrewardsexercise.ui.fetch_list.FetchViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::FetchViewModel)
}