package ir.alirezanazari.vehicles.ui

import androidx.fragment.app.Fragment


abstract class BaseFragment : Fragment() {

    fun popupBackStack() {
        activity?.onBackPressed()
    }

    abstract fun onBackPressed(): Boolean

}