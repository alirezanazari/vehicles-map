package ir.alirezanazari.vehicles.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.alirezanazari.vehicles.internal.Constants.DB.VEHICLE_TABLE

@Entity(tableName = VEHICLE_TABLE)
data class VehicleEntity(
    val type: String,
    val lat: Double,
    val lng: Double,
    val bearing: Int,
    val image: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)