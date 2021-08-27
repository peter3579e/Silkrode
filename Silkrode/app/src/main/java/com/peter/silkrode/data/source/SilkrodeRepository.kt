package com.peter.silkrode.data.source

import com.peter.silkrode.data.Result
import com.peter.silkrode.data.User

/**
 *
 * Interface to the Silkrode layers.
 */

interface SilkrodeRepository {

    suspend fun getFollowerList(): Result<List<User>>

    suspend fun getMyUserDetail(name: String): Result<User>

}