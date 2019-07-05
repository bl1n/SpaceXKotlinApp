package com.lft.spacexkotlinapp.data.source.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.lft.spacexkotlinapp.data.source.model.Launch
import io.reactivex.Single

@Dao
interface SpaceXDao {
    @Query("select * from launch")
    fun querryLaunches(): Single<List<Launch>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllLaunches(launches:List<Launch>)
}