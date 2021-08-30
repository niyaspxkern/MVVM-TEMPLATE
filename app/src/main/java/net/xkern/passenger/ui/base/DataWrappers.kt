package net.xkern.passenger.ui.base

import net.xkern.passenger.data.ErrorBody


sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val throwable: Throwable?) : Result<Nothing>()
    object InProgress : Result<Nothing>()
}

sealed class ExceptionEvent {
    data class Throw(val errorBody: ErrorBody?, val errorCode: Int?, val throwable: Throwable?) :
            ExceptionEvent()

    object Finish : ExceptionEvent()
}

sealed class Event {
    data class Data(val id: String) :
            Event()

    object Finish : Event()
}


