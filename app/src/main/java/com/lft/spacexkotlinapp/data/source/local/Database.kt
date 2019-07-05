package com.lft.spacexkotlinapp.data.source.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.lft.spacexkotlinapp.data.source.model.Launch

@Database(entities = [Launch::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun spaceXDao(): SpaceXDao
}