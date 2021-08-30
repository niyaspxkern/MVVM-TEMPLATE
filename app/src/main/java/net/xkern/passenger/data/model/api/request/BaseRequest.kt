package net.xkern.passenger.data.model.api.request

import com.google.gson.annotations.SerializedName

data class BaseRequest(
    @SerializedName("device_id")
    var deviceId: String,
    @SerializedName("device_type")
    var deviceType: String? = null
)