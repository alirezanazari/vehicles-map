package ir.alirezanazari.vehicles.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.internal.Logger
import ir.alirezanazari.vehicles.ui.BaseFragment
import org.koin.android.ext.android.inject

class VehicleListFragment : BaseFragment() {

    private val viewModel: VehicleListViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        viewModel.getVehiclesList()
    }

    private fun setupListeners() {
        viewModel.vehiclesResponse.observe(viewLifecycleOwner, Observer {
            Logger.showLog("size : ${it?.size}")
        })

        viewModel.loaderVisibilityListener.observe(viewLifecycleOwner, Observer {

        })

        viewModel.errorVisibilityListener.observe(viewLifecycleOwner, Observer {

        })

    }

    override fun onBackPressed(): Boolean = true

}
