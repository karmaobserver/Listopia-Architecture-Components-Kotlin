package com.aleksej.makaji.listopia

import android.app.Activity
import android.app.Application
import android.app.Service
import com.aleksej.makaji.listopia.di.AppInjector
import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Singleton
class ListopiaApp : Application(), HasActivityInjector, HasServiceInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var serviceAndroidInjector: DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
        if (BuildConfig.DEBUG) {
            //Timber configuration
            Timber.plant(Timber.DebugTree())
            //Stetho configuration
            Stetho.initializeWithDefaults(this)
        }

    }

    override fun activityInjector() = dispatchingAndroidInjector

    override fun serviceInjector(): AndroidInjector<Service> = serviceAndroidInjector
}