package net.unboxit.massrfid.common.di

import android.content.Context
import android.media.audiofx.EnvironmentalReverb
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.MultiProcessDataStoreFactory
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.dataStoreFile
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import net.unboxit.massrfid.model.UserPreferences
import javax.inject.Singleton

private const val USER_PREFERENCES = "user_preferences"
private const val DATA_STORE_FILE_NAME = "user_prefs.pb"
@Module
@InstallIn(SingletonComponent::class)
object StorageModule {
    @Provides
    @Singleton
    fun provideDataStore(@ApplicationContext appContext: Context): DataStore<Preferences> =
        PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler { emptyPreferences() },
            migrations = listOf(SharedPreferencesMigration(appContext, USER_PREFERENCES)),
            scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
            produceFile = { appContext.preferencesDataStoreFile(USER_PREFERENCES) }
        )

//    @Singleton
//    @Provides
//    fun provideProtoDataStore(@ApplicationContext appContext: Context) : DataStore<UserPreferences> =
//        DataStoreFactory.create(
//            serializer = UserPreferencesSerializer,
//            produceFile = { appContext.dataStoreFile(DATA_STORE_FILE_NAME)},
//            corruptionHandler = null,
//            migrations = listOf(
//                SharedPreferencesMigration(
//                    appContext,
//                    USER_PREFERENCES)),
//            scope = CoroutineScope(Dispatchers.IO + SupervisorJob())
//        )
}