package ir.alirezanazari.vehicles.data.net

import ir.alirezanazari.vehicles.data.net.entity.Vehicle


interface NetworkDataManager {

    suspend fun fetchVehiclesList(): List<Vehicle>?
}