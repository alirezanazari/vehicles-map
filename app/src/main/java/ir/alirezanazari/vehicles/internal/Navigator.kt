package ir.alirezanazari.vehicles.internal

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.ui.list.VehicleListFragment
import ir.alirezanazari.vehicles.ui.map.MapFragment


class Navigator {

    companion object {

        fun openVehiclesList(fm: FragmentManager) {
            load(true, fm, VehicleListFragment())
        }

        fun openMap(fm: FragmentManager?) {
            load(false, fm, MapFragment())
        }

        private fun load(isReplace: Boolean, fm: FragmentManager?, fragment: Fragment) {
            if (isReplace) {
                fm?.let {
                    it.beginTransaction()
                        .addToBackStack(fragment.javaClass.name)
                        .replace(R.id.fragments_container, fragment, fragment.javaClass.name)
                        .commit()
                }
            } else {
                fm?.let{
                    it.beginTransaction()
                        .addToBackStack(fragment.javaClass.name)
                        .add(R.id.fragments_container, fragment, fragment.javaClass.name)
                        .commit()
                }
            }
        }
    }
}