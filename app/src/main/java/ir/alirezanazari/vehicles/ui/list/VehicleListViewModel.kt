package ir.alirezanazari.vehicles.ui.list

import androidx.lifecycle.viewModelScope
import ir.alirezanazari.vehicles.data.net.entity.Vehicle
import ir.alirezanazari.vehicles.data.repository.VehicleRepository
import ir.alirezanazari.vehicles.internal.SingleLiveEvent
import ir.alirezanazari.vehicles.ui.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleListViewModel(
    private val repository: VehicleRepository
) : BaseViewModel() {

    val vehiclesResponse = SingleLiveEvent<List<Vehicle>?>()

    fun getVehiclesList() {
        viewModelScope.launch(Dispatchers.IO) {
            setLoaderState(true)

            val response = repository.getVehicles()
            if (response != null) {
                vehiclesResponse.postValue(response)
                setLoaderState(false)
            } else {
                setLoaderState(false, isEffectRetry = true)
            }
        }
    }
}
