package fr.dappli.app.core.di

import dagger.Component
import fr.dappli.app.core.di.modules.CoreModule
import fr.dappli.sdk.core.di.BaseCoreComponent

@Component(
    modules = [CoreModule::class]
)
interface ApplicationCoreComponent : BaseCoreComponent {

    @Component.Factory interface Factory {
        fun create(): ApplicationCoreComponent
    }

}