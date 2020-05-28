package ir.alirezanazari.vehicles.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.ui.BaseFragment
import kotlinx.android.synthetic.main.map_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.inject

class MapFragment : BaseFragment(), OnMapReadyCallback {

    private val viewModel: MapViewModel by inject()
    private lateinit var map: GoogleMap
    private lateinit var mapFragment: SupportMapFragment
    private val DEFAULT_LATLNG = LatLng(35.757566, 51.410379) // Vanak, Tehran

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.map_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupMap()
        setupListeners()
    }

    private fun setupListeners() {
        btnBack.setOnClickListener {
            popupBackStack()
        }
    }

    private fun setupMap() {

        mapFragment = childFragmentManager.findFragmentById(R.id.mapView) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun onBackPressed(): Boolean = true

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(DEFAULT_LATLNG, 17f))
        addMarkersToMap()
    }

    private fun addMarkersToMap() {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val vehicles = viewModel.getVehiclesFromDb()

            vehicles.forEach {
                val markerDrawable = Glide.with(this@MapFragment)
                    .load(it.image)
                    .centerCrop()
                    .into(100, 100)
                    .get()
                val markerBitmap = markerDrawable.toBitmap()

                withContext(Dispatchers.Main) {
                    map.addMarker(
                        MarkerOptions()
                            .position(LatLng(it.lat, it.lng))
                            .title(it.type)
                            .rotation(it.bearing.toFloat())
                            .icon(BitmapDescriptorFactory.fromBitmap(markerBitmap))
                    )
                }
            }
        }
    }

}
