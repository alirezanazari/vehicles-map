package ir.alirezanazari.vehicles.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.alirezanazari.vehicles.data.db.entity.VehicleEntity
import ir.alirezanazari.vehicles.internal.Constants.DB.VEHICLE_TABLE

@Dao
interface VehicleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vehicles: VehicleEntity)

    @Query("select * from $VEHICLE_TABLE")
    suspend fun getVehicles(): List<VehicleEntity>

    @Query("delete from $VEHICLE_TABLE")
    suspend fun clear()
}