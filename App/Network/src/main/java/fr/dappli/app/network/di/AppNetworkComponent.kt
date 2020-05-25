package fr.dappli.app.network.di

import dagger.Component
import fr.dappli.sdk.network.di.BaseNetworkComponent

@Component
interface AppNetworkComponent : BaseNetworkComponent {

    @Component.Factory interface Factory {
        fun create(): AppNetworkComponent
    }
}