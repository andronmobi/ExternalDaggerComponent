package fr.dappli.app.core

import android.content.Context
import fr.dappli.app.core.di.ApplicationCoreComponent

interface CoreComponentProvider {
    val coreComponent: ApplicationCoreComponent
}

val Context.coreComponent: ApplicationCoreComponent
    get() = (applicationContext as CoreComponentProvider).coreComponent
