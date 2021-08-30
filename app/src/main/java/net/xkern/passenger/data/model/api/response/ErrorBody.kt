package net.xkern.passenger.data.model.api.response


import com.google.gson.annotations.SerializedName

data class ErrorBody(
    @SerializedName("httpCode")
    var httpCode: Int,
    @SerializedName("message")
    var message: String,
    @SerializedName("response")
    var response: String
)