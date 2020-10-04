package com.thideoli.gokinterview.module

import com.thideoli.gokinterview.repository.Repository
import com.thideoli.gokinterview.repository.remote.ApiHelper
import com.thideoli.gokinterview.repository.remote.ApiHelperImpl
import org.koin.dsl.module

val repositoryModule = module {
    single {
        Repository(get())
    }

    single<ApiHelper> {
        return@single ApiHelperImpl(get())
    }
}