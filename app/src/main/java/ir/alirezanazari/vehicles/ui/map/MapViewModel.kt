package ir.alirezanazari.vehicles.ui.map

import ir.alirezanazari.vehicles.data.db.dao.VehicleDao
import ir.alirezanazari.vehicles.data.db.entity.VehicleEntity
import ir.alirezanazari.vehicles.ui.BaseViewModel

class MapViewModel(
    private val db: VehicleDao
) : BaseViewModel() {

    suspend fun getVehiclesFromDb(): List<VehicleEntity> {
        return db.getVehicles()
    }

}
