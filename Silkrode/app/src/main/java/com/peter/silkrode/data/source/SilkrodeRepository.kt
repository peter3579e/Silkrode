package com.peter.silkrode.data.source

import com.peter.silkrode.data.Result
import com.peter.silkrode.data.User

interface SilkrodeRepository {

    suspend fun getFollowerList(): Result<List<User>>

    suspend fun getMyUserDetail(name: String): Result<User>

}