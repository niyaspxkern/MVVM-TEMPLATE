package net.xkern.passenger.di.modules

import net.xkern.passenger.di.PreferenceInfo
import net.xkern.passenger.utils.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PreferenceModule {

    @Provides
    @PreferenceInfo
    fun providePreferenceName() = AppConstants.PREF_NAME
}