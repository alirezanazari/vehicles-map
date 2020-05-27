package ir.alirezanazari.vehicles.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ir.alirezanazari.vehicles.R
import ir.alirezanazari.vehicles.internal.Navigator
import ir.alirezanazari.vehicles.ui.list.VehicleListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Navigator.openVehiclesList(supportFragmentManager)
    }

    override fun onBackPressed() {
        if(supportFragmentManager.backStackEntryCount == 1){
            val fragment = supportFragmentManager.findFragmentById(R.id.fragments_container)
            if(fragment is VehicleListFragment){
                if(fragment.onBackPressed()) finish()
                return
            }else {
                finish()
                return
            }
        }
        super.onBackPressed()
    }
}
