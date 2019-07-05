package com.lft.spacexkotlinapp.data

import android.util.Log
import com.lft.spacexkotlinapp.Utils.Utils
import com.lft.spacexkotlinapp.data.source.local.SpaceXDao
import com.lft.spacexkotlinapp.data.source.model.Launch
import com.lft.spacexkotlinapp.data.source.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject

class SpaceXRepository @Inject constructor(
    val apiInterface: ApiInterface,
    val spaceXDao: SpaceXDao,
    val utils: Utils
) {

    fun getLaunches(): Observable<List<Launch>>{
        val hasConnection = utils.isConnectedToInternet()
        var observableFromApi: Observable<List<Launch>>?=null
        if(hasConnection){
            observableFromApi = getLaunchesFromApi()
        }
        val observableFromDB = getLaunchesFromDB()

        return if(hasConnection) Observable.concatArrayEager(observableFromApi, observableFromDB)
        else observableFromDB
    }

    private fun getLaunchesFromDB(): Observable<List<Launch>> {
        return spaceXDao.querryLaunches()
            .toObservable()
            .doOnNext {
                Log.e("REPOSITORY_DB", it.size.toString() )
            }
    }

    private fun getLaunchesFromApi(): Observable<List<Launch>>? {
        return apiInterface.getLaunches()
            .doOnNext{
                spaceXDao.insertAllLaunches(it)
                Log.e("REPOSITORY_API", it.size.toString() )
            }
    }


}