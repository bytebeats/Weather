package me.bytebeats.plugin.weather.data.simple

data class SimpleCity(
    val name: String,
    val adm2: String,
    val adm1: String,
    val country: String,
) {
    fun string(): String = "$name, $adm2, $adm1, $country"
}
