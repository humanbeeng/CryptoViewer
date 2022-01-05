package dev.humanbeeng.cryptoviewer.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.humanbeeng.cryptoviewer.common.Constants
import dev.humanbeeng.cryptoviewer.data.remote.PaprikaApi
import dev.humanbeeng.cryptoviewer.data.repository.CoinRepositoryImpl
import dev.humanbeeng.cryptoviewer.domain.repository.CoinRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): PaprikaApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(PaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: PaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

}