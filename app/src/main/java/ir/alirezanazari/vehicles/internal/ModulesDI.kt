package ir.alirezanazari.vehicles.internal

import ir.alirezanazari.vehicles.data.db.VehiclesDatabase
import ir.alirezanazari.vehicles.data.net.ApiConfig
import ir.alirezanazari.vehicles.data.net.NetworkDataManager
import ir.alirezanazari.vehicles.data.net.NetworkDataManagerImpl
import ir.alirezanazari.vehicles.data.repository.VehicleRepository
import ir.alirezanazari.vehicles.data.repository.VehicleRepositoryImpl
import ir.alirezanazari.vehicles.ui.list.VehicleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModules = module {

    single { ApiConfig.invoke() }
    single<NetworkDataManager> { NetworkDataManagerImpl(get()) }
    single { VehiclesDatabase(get()) }

    factory<VehicleRepository> { VehicleRepositoryImpl(get() , get<VehiclesDatabase>().getVehicleDao()) }

    viewModel { VehicleListViewModel(get()) }
}