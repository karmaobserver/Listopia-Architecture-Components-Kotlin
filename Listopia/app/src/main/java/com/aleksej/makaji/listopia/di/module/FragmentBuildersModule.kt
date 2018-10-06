package com.aleksej.makaji.listopia.di.module

import com.aleksej.makaji.listopia.screen.shoppinglist.ShoppingListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeShoppingListFragment(): ShoppingListFragment
}