package ir.alirezanazari.vehicles.data.net.entity

import com.google.gson.annotations.SerializedName

data class VehiclesListResponse(
    @SerializedName("vehicles")
    val vehicles: List<Vehicle>
)