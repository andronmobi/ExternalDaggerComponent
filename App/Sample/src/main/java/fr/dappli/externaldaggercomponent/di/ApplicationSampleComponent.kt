package fr.dappli.externaldaggercomponent.di

import dagger.Component
import fr.dappli.app.core.di.ApplicationCoreComponent

@Component(
    dependencies = [ApplicationCoreComponent::class]
)
interface ApplicationSampleComponent {

    @Component.Factory
    interface Factory {

        fun create(
            coreComponent: ApplicationCoreComponent
        ): ApplicationSampleComponent
    }
}