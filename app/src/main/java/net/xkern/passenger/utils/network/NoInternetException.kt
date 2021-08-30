package net.xkern.passenger.utils.network

import java.io.IOException

class NoInternetException : IOException() {
    override val message: String
        get() = "No network available, Please check your WiFi or Data connection."
}