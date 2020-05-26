package ir.alirezanazari.vehicles.ui.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ir.alirezanazari.vehicles.R

class VehicleListFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleListFragment()
    }

    private lateinit var viewModel: VehicleListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.vehicle_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(VehicleListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
