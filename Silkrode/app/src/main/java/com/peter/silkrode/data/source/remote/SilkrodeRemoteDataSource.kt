package com.peter.silkrode.data.source.remote

import com.peter.silkrode.R
import com.peter.silkrode.data.User
import com.peter.silkrode.util.Util.getString
import com.peter.silkrode.util.Util.isInternetConnected
import com.peter.silkrode.data.Result
import com.peter.silkrode.data.source.SilkrodeDataSource
import com.peter.silkrode.network.SilkrodeApi
import com.peter.silkrode.util.Logger

/**
 *
 * Implementation of the Silkrode source that from network.
 */

object SilkrodeRemoteDataSource : SilkrodeDataSource {

    override suspend fun getFollowerList(): Result<List<User>> {

        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {

            val result = SilkrodeApi.retrofitService.getFollowerList()

            Result.Fail("failed")

            Result.Success(result)
        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

    override suspend fun getMyUserDetail(name: String): Result<User> {

        if (!isInternetConnected()) {
            return Result.Fail(getString(R.string.internet_not_connected))
        }

        return try {

            val result = SilkrodeApi.retrofitService.getMyUserDetail(name)

            result.error?.let {
                return Result.Fail(it)
            }

            Result.Success(result)
        } catch (e: Exception) {
            Logger.w("[${this::class.simpleName}] exception=${e.message}")
            Result.Error(e)
        }
    }

}