package ir.alirezanazari.vehicles.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.ui.BaseFragment
import org.koin.android.ext.android.inject

class MapFragment : BaseFragment(), OnMapReadyCallback {

    private val viewModel: MapViewModel by inject()
    private lateinit var map: GoogleMap
    private lateinit var mapFragment: SupportMapFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap()
    }

    private fun setupMap() {

        mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onBackPressed(): Boolean = true

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

    }

}
