package net.xkern.passenger.data.remote.coroutine

sealed class NetworkResponse<out T : Any, out U : Any> {
    /**
     * Success response with body
     */
    data class Success<T : Any>(val body: T) : NetworkResponse<T, Nothing>()

    /**
     * Failure response with body
     */
    data class Error<U : Any>(val body: U?, val code: Int?,val throwable: Throwable?) : NetworkResponse<Nothing, U>()
}