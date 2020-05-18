package fr.dappli.sdk.network.di

import dagger.Component

@Component(dependencies = [BaseNetworkComponent::class])
interface SdkNetworkComponent {

    @Component.Factory
    interface Factory {
        fun create(baseNetworkComponent: BaseNetworkComponent): SdkNetworkComponent
    }
}