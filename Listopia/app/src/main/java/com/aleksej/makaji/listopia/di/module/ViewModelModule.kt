package com.aleksej.makaji.listopia.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aleksej.makaji.listopia.di.annotation.ViewModelKey
import com.aleksej.makaji.listopia.factory.ViewModelFactory
import com.aleksej.makaji.listopia.screen.shoppinglist.ShoppingListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ShoppingListViewModel::class)
    abstract fun bindHomeViewModel(shoppingListViewModel: ShoppingListViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}