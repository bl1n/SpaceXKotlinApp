package com.lft.spacexkotlinapp.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import com.lft.spacexkotlinapp.Utils.Constants
import com.lft.spacexkotlinapp.data.source.local.Database
import com.lft.spacexkotlinapp.data.source.local.SpaceXDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule (val app: Application){

    @Provides
    @Singleton
    fun providesApplication():Application = app

    @Provides
    @Singleton
    fun providesSapceXDatabase(app: Application): Database =
        Room.databaseBuilder(app,
            Database::class.java, Constants.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()


    @Provides
    @Singleton
    fun providesSpaceXDao(database: Database): SpaceXDao = database.spaceXDao()



}