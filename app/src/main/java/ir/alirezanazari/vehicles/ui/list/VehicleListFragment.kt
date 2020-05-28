package ir.alirezanazari.vehicles.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.internal.Navigator
import ir.alirezanazari.vehicles.ui.BaseFragment
import kotlinx.android.synthetic.main.vehicle_list_fragment.*
import org.koin.android.ext.android.inject

class VehicleListFragment : BaseFragment() {

    private val viewModel: VehicleListViewModel by inject()
    private val vehiclesAdapter: VehiclesAdapter by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_list_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupVehiclesList()
        setupListeners()
        viewModel.getVehiclesList()
    }

    private fun setupVehiclesList() {
        rvVehicles.apply {
            adapter = vehiclesAdapter
        }
    }

    private fun setupListeners() {
        btnMap.setOnClickListener {
            Navigator.openMap(activity?.supportFragmentManager)
        }

        viewModel.vehiclesResponse.observe(viewLifecycleOwner, Observer { items ->
            items?.let {
                vehiclesAdapter.setItems(it)
            }
        })

        viewModel.loaderVisibilityListener.observe(viewLifecycleOwner, Observer {
            it?.let { state ->
                pbLoading.visibility = if (state) View.VISIBLE else View.GONE
            }
        })

        viewModel.errorVisibilityListener.observe(viewLifecycleOwner, Observer {
            it?.let { state ->
                if (state) {
                    tvError.visibility = View.VISIBLE
                    btnRetry.visibility = View.VISIBLE
                    btnMap.visibility = View.GONE
                } else {
                    tvError.visibility = View.GONE
                    btnRetry.visibility = View.GONE
                    btnMap.visibility = View.VISIBLE
                }
            }
        })

    }

    override fun onBackPressed(): Boolean = true

}
