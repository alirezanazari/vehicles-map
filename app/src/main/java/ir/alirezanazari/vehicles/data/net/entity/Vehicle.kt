package ir.alirezanazari.vehicles.data.net.entity


import com.google.gson.annotations.SerializedName

data class Vehicle(
    @SerializedName("type")
    val type: String,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("bearing")
    val bearing: Int,
    @SerializedName("image_url")
    val imageUrl: String
)