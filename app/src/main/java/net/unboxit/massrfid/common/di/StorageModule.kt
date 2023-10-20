package net.unboxit.massrfid.common.di

import android.content.Context
import android.media.audiofx.EnvironmentalReverb
import androidx.datastore.core.DataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
//    @Provides
//    @Singleton
//    fun provideDataStore(@ApplicationContext context: Context): DataStore<EnvironmentalReverb.Settings> =
//        MultiProcessDataStoreFactory.create()
}