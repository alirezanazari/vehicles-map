package ir.alirezanazari.vehicles.data.net

import ir.alirezanazari.vehicles.data.net.entity.VehiclesListResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET


interface Api {

    @GET("test/document.json")
    fun getVehiclesLocations(): Deferred<VehiclesListResponse>
}