package com.lft.spacexkotlinapp.di.component

import com.lft.spacexkotlinapp.MainActivity
import com.lft.spacexkotlinapp.di.modules.AppModule
import com.lft.spacexkotlinapp.di.modules.BuildersModule
import com.lft.spacexkotlinapp.di.modules.NetModule
import dagger.Component


@Component(modules = [AppModule::class, NetModule::class, BuildersModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}