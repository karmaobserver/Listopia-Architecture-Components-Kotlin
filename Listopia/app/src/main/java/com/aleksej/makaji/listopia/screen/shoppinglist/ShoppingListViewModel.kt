package com.aleksej.makaji.listopia.screen.shoppinglist

import androidx.lifecycle.ViewModel
import com.aleksej.makaji.listopia.data.usecase.GetShoppingListsUseCase
import com.aleksej.makaji.listopia.data.usecase.UseCase
import timber.log.Timber
import java.util.*
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListViewModel @Inject constructor(private val mGetShoppingListsUseCase: GetShoppingListsUseCase) : ViewModel() {

    val shoppingListsEvent = mGetShoppingListsUseCase.invoke(Unit)
}