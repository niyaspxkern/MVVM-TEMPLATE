package net.xkern.passenger.di.modules

import android.content.Context
import androidx.room.Room
import net.xkern.passenger.data.local.db.AppDatabase
import net.xkern.passenger.data.local.db.AppDbHelper
import net.xkern.passenger.data.local.db.DbHelper
import net.xkern.passenger.di.DatabaseInfo
import net.xkern.passenger.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DbModule {

    @Provides
    @DatabaseInfo
    fun provideDatabaseName() = AppConstants.DATABASE_NAME

    @Provides
    @Singleton
    fun provideAppDatabase(@DatabaseInfo dbName: String, @ApplicationContext context: Context) =
        Room
            .databaseBuilder(context, AppDatabase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideDbHelper(appDbHelper: AppDbHelper): DbHelper = appDbHelper
}