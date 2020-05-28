package ir.alirezanazari.vehicles.data.repository

import ir.alirezanazari.vehicles.data.db.dao.VehicleDao
import ir.alirezanazari.vehicles.data.db.entity.VehicleEntity
import ir.alirezanazari.vehicles.data.net.NetworkDataManager
import ir.alirezanazari.vehicles.data.net.entity.Vehicle

class VehicleRepositoryImpl(
    private val net: NetworkDataManager,
    private val db: VehicleDao
) : VehicleRepository {

    override suspend fun getVehicles(): List<Vehicle>? {

        val netResponse = net.fetchVehiclesList()

        if (netResponse == null) {
            val dbResponse = db.getVehicles().map(::transformToVehicles)
            if (dbResponse.isNotEmpty()) return dbResponse
        } else {
            db.clear()
            netResponse.forEach { insertVehiclesToDb(it) }
            return netResponse
        }

        return null
    }

    private fun transformToVehicles(vehicle: VehicleEntity): Vehicle {
        return Vehicle(
            vehicle.type,
            vehicle.lat,
            vehicle.lng,
            vehicle.bearing,
            vehicle.image
        )
    }

    private suspend fun insertVehiclesToDb(vehicle: Vehicle) {
        db.insert(
            VehicleEntity(
                vehicle.type,
                vehicle.lat,
                vehicle.lng,
                vehicle.bearing,
                vehicle.imageUrl
            )
        )
    }

}
