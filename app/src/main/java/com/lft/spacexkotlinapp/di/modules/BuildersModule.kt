package com.lft.spacexkotlinapp.di.modules

import com.lft.spacexkotlinapp.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {
    @ContributesAndroidInjector
    abstract fun contribute():MainActivity
}