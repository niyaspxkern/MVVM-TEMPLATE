package net.xkern.passenger.data.model.api.response


import com.google.gson.annotations.SerializedName

data class LoginResponse(
        @SerializedName("user")
        var user: User
) : BaseResponse() {
    data class User(
            @SerializedName("id")
            var id: Int,
            @SerializedName("email")
            var email: String
    )
}