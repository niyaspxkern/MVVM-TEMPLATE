package net.xkern.passenger.data.remote

import net.xkern.passenger.data.ErrorBody
import net.xkern.passenger.data.remote.coroutine.NetworkResponse

typealias GenericResponse<S> = NetworkResponse<S, ErrorBody>

interface ApiInterface {

}