package com.lft.spacexkotlinapp

import android.app.Activity
import android.app.Application
import com.lft.spacexkotlinapp.di.component.DaggerAppComponent
import com.lft.spacexkotlinapp.di.modules.AppModule
import com.lft.spacexkotlinapp.di.modules.NetModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasFragmentInjector
import javax.inject.Inject

class SpaceXApplication : Application(), HasActivityInjector, HasFragmentInjector {
    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<android.app.Fragment>
    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.URL))
            .build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityInjector
    }

    override fun fragmentInjector(): AndroidInjector<android.app.Fragment> {
        return fragmentInjector
    }


}