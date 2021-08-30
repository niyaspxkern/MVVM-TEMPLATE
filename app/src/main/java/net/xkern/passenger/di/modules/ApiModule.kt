package net.xkern.passenger.di.modules

import com.google.gson.Gson
import net.xkern.passenger.data.local.prefs.AppPreferences
import net.xkern.passenger.data.remote.ApiInterface
import net.xkern.passenger.data.remote.coroutine.NetworkResponseAdapterFactory
import net.xkern.passenger.utils.network.ConnectivityInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.xkern.passenger.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit): ApiInterface =
            retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(appPreferences: AppPreferences): Retrofit {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.apply {
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
            addInterceptor(ConnectivityInterceptor())
        }
        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(NetworkResponseAdapterFactory())
                .client(okHttpClientBuilder.build())
                .build()
    }

    @Provides
    @Singleton
    fun provideGson() = Gson()

}