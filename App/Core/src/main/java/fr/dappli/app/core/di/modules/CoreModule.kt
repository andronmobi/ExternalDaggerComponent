package fr.dappli.app.core.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
class CoreModule {

    @Provides
    @Reusable
    fun provideGson(): Gson = Gson()
}