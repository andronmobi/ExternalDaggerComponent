package fr.dappli.externaldaggercomponent

import android.app.Application
import fr.dappli.app.core.CoreComponentProvider
import fr.dappli.app.core.di.ApplicationCoreComponent
import fr.dappli.app.core.di.DaggerApplicationCoreComponent
import fr.dappli.externaldaggercomponent.di.inject

class SampleApplication : Application(), CoreComponentProvider {

    override fun onCreate() {
        super.onCreate()

        inject(this)
    }

    override val coreComponent: ApplicationCoreComponent by lazy {
        DaggerApplicationCoreComponent.factory().create()
    }

}