package com.example.data.di

import android.content.Context
import com.example.data.persistence.AppDataStore
import com.example.data.persistence.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class PersistenceModule {

    @Provides
    @Singleton
    fun createAppDataStore(@ApplicationContext appContext: Context) = AppDataStore(appContext)

    @Provides
    @Singleton
    fun createSharedPreferences(@ApplicationContext appContext: Context) = Preferences(appContext)
}