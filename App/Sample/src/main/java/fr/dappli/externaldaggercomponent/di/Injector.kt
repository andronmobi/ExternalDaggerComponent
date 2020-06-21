package fr.dappli.externaldaggercomponent.di

import fr.dappli.externaldaggercomponent.SampleApplication


fun inject(application: SampleApplication) {
    DaggerApplicationSampleComponent.factory()
        .create(application.coreComponent)
}