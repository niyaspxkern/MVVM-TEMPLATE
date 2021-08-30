package net.xkern.passenger.ui.base

import androidx.lifecycle.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.xkern.passenger.data.ErrorBody
import net.xkern.passenger.data.remote.coroutine.NetworkResponse

abstract class BaseViewModel : ViewModel() {

    //Loading
    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = _loading
    fun setLoading(status: Boolean) {
        _loading.value = status
    }
    protected fun launchApiCall(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            setLoading(true)
            block()
            setLoading(false)
        }
    }

    //Exception
    private val _exceptionEvent = MutableLiveData<ExceptionEvent>()
    val exceptionEvent: LiveData<ExceptionEvent>
        get() = _exceptionEvent
    fun handleException(error: NetworkResponse.Error<ErrorBody>) {
        _exceptionEvent.value = ExceptionEvent.Throw(error.body, error.code, error.throwable)
    }
    fun settleExceptionEvent() {
        _exceptionEvent.value = ExceptionEvent.Finish
    }


    //Toast
    private val _toastEvent = MutableLiveData<Event>()
    val toastEvent: LiveData<Event>
        get() = _toastEvent
    private fun setToastEvent(data: String) {
        _toastEvent.value = Event.Data(data)
    }
    fun settleToastEvent() {
        _toastEvent.value = Event.Finish
    }
    fun showToast(message: String?) {
        if (!message.isNullOrEmpty()) setToastEvent(message)
    }

    //Back
    private val _backEvent = MutableLiveData<Event>()
    val backEvent: LiveData<Event>
        get() = _backEvent
    fun setbackEvent() {
        _backEvent.value = Event.Data("")
    }
    fun settlebackEvent() {
        _backEvent.value = Event.Finish
    }
}