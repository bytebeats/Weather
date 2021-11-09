package me.bytebeats.plugin.weather.data

data class LocationWrapper(val code: String, val location: List<Location>, val refer: Refer?) {
    fun isSuccess(): Boolean = code == "200"
}
