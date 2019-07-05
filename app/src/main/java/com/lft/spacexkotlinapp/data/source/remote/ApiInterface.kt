package com.lft.spacexkotlinapp.data.source.remote

import com.lft.spacexkotlinapp.data.source.model.Launch
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {

    @GET("launches")
    fun getLaunches(): Observable<List<Launch>>
}