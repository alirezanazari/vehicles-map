package ir.alirezanazari.vehicles.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ir.alirezanazari.vehicles.data.db.dao.VehicleDao
import ir.alirezanazari.vehicles.data.db.entity.VehicleEntity

@Database(
    entities = [VehicleEntity::class],
    version = 1
)
abstract class VehiclesDatabase: RoomDatabase(){

    abstract fun getVehicleDao(): VehicleDao

    companion object{
        @Volatile private var instance : VehiclesDatabase? = null
        private val LOCK = Any()

        operator fun invoke (context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext , VehiclesDatabase::class.java , "vehicles_db.db"
        ).build()
    }
}