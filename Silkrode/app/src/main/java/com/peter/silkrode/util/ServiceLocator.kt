package com.peter.silkrode.util

import androidx.annotation.VisibleForTesting
import com.peter.silkrode.data.source.DefaultSilkrodeRepository
import com.peter.silkrode.data.source.SilkrodeRepository
import com.peter.silkrode.data.source.remote.SilkrodeRemoteDataSource

object ServiceLocator {

    @Volatile
    var silkrodeRepository: SilkrodeRepository? = null
        @VisibleForTesting set

    fun provideTasksRepository(): SilkrodeRepository {
        synchronized(this) {
            return silkrodeRepository
                    ?: silkrodeRepository
                    ?: createSilkrodeRepository()
        }
    }

    private fun createSilkrodeRepository(): SilkrodeRepository {
        return DefaultSilkrodeRepository(SilkrodeRemoteDataSource)
    }

}