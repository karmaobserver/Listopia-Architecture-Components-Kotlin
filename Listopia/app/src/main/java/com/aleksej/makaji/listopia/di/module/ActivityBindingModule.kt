package com.aleksej.makaji.listopia.di.module

import com.aleksej.makaji.listopia.HomeActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Suppress("unused")
@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [(FragmentBuildersModule::class)])
    abstract fun homeActivity(): HomeActivity
}