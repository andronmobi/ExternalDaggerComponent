package fr.dappli.sdk.core.di

import dagger.Component

@Component(
    dependencies = [BaseCoreComponent::class]
)
interface SdkCoreComponent {

    @Component.Factory interface Factory {
        fun create(baseCoreComponent: BaseCoreComponent): SdkCoreComponent
    }
}