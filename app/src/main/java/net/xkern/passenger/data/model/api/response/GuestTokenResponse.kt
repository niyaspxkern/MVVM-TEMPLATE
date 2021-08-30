package net.xkern.passenger.data.model.api.response


import com.google.gson.annotations.SerializedName

data class GuestTokenResponse(
    @SerializedName("token")
    var token: String
): BaseResponse()