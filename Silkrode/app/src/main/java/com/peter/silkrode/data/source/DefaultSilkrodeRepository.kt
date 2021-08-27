package com.peter.silkrode.data.source

import com.peter.silkrode.data.Result
import com.peter.silkrode.data.User
import com.peter.silkrode.data.source.remote.SilkrodeRemoteDataSource

/**
 *
 * Concrete implementation to load Silkrode sources.
 */


class DefaultSilkrodeRepository (private val silkrodeRemoteDataSource: SilkrodeDataSource) : SilkrodeRepository {
    override suspend fun getFollowerList(): Result<List<User>> {
        return silkrodeRemoteDataSource.getFollowerList()
    }

    override suspend fun getMyUserDetail(name: String): Result<User> {
        return silkrodeRemoteDataSource.getMyUserDetail(name)
    }

}