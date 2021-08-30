package net.xkern.passenger.utils.network

import androidx.annotation.NonNull
import okhttp3.Interceptor
import okhttp3.Response
import net.xkern.passenger.utils.network.monitor.ConnectivityStateHolder
import java.io.IOException

class ConnectivityInterceptor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(@NonNull chain: Interceptor.Chain): Response {
        if (!ConnectivityStateHolder.isConnected)
            throw NoInternetException()
        return chain.proceed(chain.request())
    }

}