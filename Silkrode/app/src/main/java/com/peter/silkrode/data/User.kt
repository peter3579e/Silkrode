package com.peter.silkrode.data

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    @Json(name = "name") var name: String? = "",
    @Json(name = "login") var login: String? = "",
    @Json(name = "type") var type: String? = "",
    @Json(name = "avatar_url") var avatar_url: String? = "",
    @Json(name = "location") var location: String? = "",
    @Json(name = "html_url") var html_url: String? = "",
    @Json(name = "followers") var followers: Int? = 0,
    @Json(name = "following") var following: Int? = 0,
    @Json(name = "email") var email: String? = "",
    val error: String? = null
):Parcelable{}
