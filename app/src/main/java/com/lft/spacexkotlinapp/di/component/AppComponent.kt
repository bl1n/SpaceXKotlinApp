package com.lft.spacexkotlinapp.di.component

import com.lft.spacexkotlinapp.SpaceXApplication
import com.lft.spacexkotlinapp.di.modules.AppModule
import com.lft.spacexkotlinapp.di.modules.BuildersModule
import com.lft.spacexkotlinapp.di.modules.NetModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules =
    [AppModule::class, NetModule::class, BuildersModule::class, AndroidInjectionModule::class]
)
interface AppComponent {
    fun inject(app: SpaceXApplication)
}