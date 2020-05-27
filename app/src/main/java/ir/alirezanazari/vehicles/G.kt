package ir.alirezanazari.vehicles

import android.app.Application
import ir.alirezanazari.vehicles.internal.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class G : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@G)
            modules(appModules)
        }
    }
}