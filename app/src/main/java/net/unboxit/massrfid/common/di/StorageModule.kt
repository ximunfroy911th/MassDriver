package net.unboxit.massrfid.common.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
//    @Provides
//    @Singleton
//    fun provideDataStore(@ApplicationContext context: Context): DataStore<EnvironmentalReverb.Settings> =
//        MultiProcessDataStoreFactory.create()
}