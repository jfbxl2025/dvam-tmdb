package eu.epfc.tmdb

import android.app.Application
import eu.epfc.tmdb.data.AppContainer
import eu.epfc.tmdb.data.DefaultAppContainer

class TmdbApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer
    }
}