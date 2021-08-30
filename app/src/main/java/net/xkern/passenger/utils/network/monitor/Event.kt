package net.xkern.passenger.utils.network.monitor

sealed class Event {

    class ConnectivityEvent(val isConnected: Boolean) : Event()
}