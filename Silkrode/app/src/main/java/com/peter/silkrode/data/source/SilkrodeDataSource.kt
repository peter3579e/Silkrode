package com.peter.silkrode.data.source

import com.peter.silkrode.data.Result
import com.peter.silkrode.data.User

/**
 *
 * Main entry point for accessing Silkrode sources.
 */

interface SilkrodeDataSource {

    suspend fun getFollowerList(): Result<List<User>>

    suspend fun getMyUserDetail(name: String): Result<User>
}