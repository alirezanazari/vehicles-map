package ir.alirezanazari.vehicles.data.repository

import ir.alirezanazari.vehicles.data.net.entity.Vehicle


interface VehicleRepository {

    suspend fun getVehicles(): List<Vehicle>?
}