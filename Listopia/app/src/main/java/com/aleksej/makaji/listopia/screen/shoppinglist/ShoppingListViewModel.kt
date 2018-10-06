package com.aleksej.makaji.listopia.screen.shoppinglist

import androidx.lifecycle.ViewModel
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListViewModel @Inject constructor() : ViewModel() {

    fun testDagger() {
        Timber.d("Test ViewModel Dagger")
    }
}