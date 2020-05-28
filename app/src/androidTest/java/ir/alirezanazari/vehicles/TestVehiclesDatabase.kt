package ir.alirezanazari.vehicles

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import ir.alirezanazari.vehicles.data.db.VehiclesDatabase
import ir.alirezanazari.vehicles.data.db.dao.VehicleDao
import ir.alirezanazari.vehicles.data.db.entity.VehicleEntity
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TestVehiclesDatabase {

    private lateinit var db: VehiclesDatabase
    private lateinit var dao: VehicleDao
    private lateinit var vehicle: VehicleEntity

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, VehiclesDatabase::class.java).build()
        dao = db.getVehicleDao()
        vehicle = VehicleEntity("ECO" , 32.11 , 51.13 , 250 , "")
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }


    @Test
    fun test_write_read_new_vehicle() = runBlocking{
        dao.insert(vehicle)
        val vehicles = dao.getVehicles()
        assertThat(vehicles[0] , equalTo(vehicle))
    }

}