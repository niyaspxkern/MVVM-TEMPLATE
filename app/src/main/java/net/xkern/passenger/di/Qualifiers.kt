package net.xkern.passenger.di

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PreferenceInfo

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class DatabaseInfo