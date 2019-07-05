package com.lft.spacexkotlinapp.data.source.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity
data class Launch(
    @PrimaryKey
    @SerializedName("flight_number")
    @ColumnInfo(name = "flight_number")
    val flightNumber: Int,

    @SerializedName("mission_name")
    @ColumnInfo(name = "mission_name")
    val missionName: String,

    @SerializedName("launch_date_unix")
    @ColumnInfo(name = "launch_date_unix")
    val launchDateUnix: String,

    @SerializedName("launch_success")
    @ColumnInfo(name = "launch_success")
    val launchSuccess: Boolean,

    @SerializedName("details")
    @ColumnInfo(name = "details")
    val details: String
) : Serializable