package ir.alirezanazari.vehicles.data.net

import ir.alirezanazari.vehicles.data.net.entity.Vehicle
import ir.alirezanazari.vehicles.internal.Logger
import retrofit2.HttpException


class NetworkDataManagerImpl(
    private val api: Api
) : NetworkDataManager {

    override suspend fun fetchVehiclesList(): List<Vehicle>? {
        return try {
            val response = api.getVehiclesLocations().await()
            response.vehicles
        } catch (e: HttpException) {
            Logger.showLog("Error fetch vehicles : ${e.message()}")
            null
        }
    }
}