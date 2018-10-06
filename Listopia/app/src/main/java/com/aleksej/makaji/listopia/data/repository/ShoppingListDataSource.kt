package com.aleksej.makaji.listopia.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aleksej.makaji.listopia.data.event.Event
import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
interface ShoppingListDataSource {
    fun getShoppingLists(): LiveData<Event<PagedList<ShoppingListModel>>>
}