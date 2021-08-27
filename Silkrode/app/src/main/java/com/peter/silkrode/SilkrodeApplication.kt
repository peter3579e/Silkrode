package com.peter.silkrode

import android.app.Application
import com.peter.silkrode.data.source.SilkrodeRepository
import com.peter.silkrode.util.ServiceLocator
import kotlin.properties.Delegates

class SilkrodeApplication : Application() {

    // Depends on the flavor,
    val silkrodeRepository: SilkrodeRepository
        get() = ServiceLocator.provideTasksRepository()


    companion object {
        var instance: SilkrodeApplication by Delegates.notNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

}