package ir.alirezanazari.vehicles

import ir.alirezanazari.vehicles.data.net.Api
import ir.alirezanazari.vehicles.data.net.ApiConfig
import ir.alirezanazari.vehicles.data.net.NetworkDataManager
import ir.alirezanazari.vehicles.data.net.NetworkDataManagerImpl
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.notNullValue
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.internal.runners.JUnit4ClassRunner
import org.junit.runner.RunWith
import org.hamcrest.CoreMatchers.`is` as Is

@RunWith(JUnit4ClassRunner::class)
class TestNetworkManager {

    private lateinit var api: Api
    private lateinit var net: NetworkDataManager

    @Before
    fun init() {
        api = ApiConfig.invoke()
        net = NetworkDataManagerImpl(api)
    }

    @Test
    fun check_vehicles_list_not_null(): Unit = runBlocking {
        val resp = net.fetchVehiclesList()
        assertThat(resp, Is(notNullValue()))
    }

    @Test
    fun check_vehicles_list_not_empty(): Unit = runBlocking {
        val resp = net.fetchVehiclesList()
        assertThat(resp.isNullOrEmpty(), Is(false))
    }

    @Test
    fun check_vehicles_list_size(): Unit = runBlocking {
        val resp = net.fetchVehiclesList()
        assertThat(resp?.size, Is(not(0)))
    }

}