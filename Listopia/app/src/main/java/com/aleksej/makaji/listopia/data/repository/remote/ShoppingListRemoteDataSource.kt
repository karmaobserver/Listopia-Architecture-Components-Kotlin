package com.aleksej.makaji.listopia.data.repository.remote

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.aleksej.makaji.listopia.data.event.Event
import com.aleksej.makaji.listopia.data.repository.ShoppingListDataSource
import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListRemoteDataSource @Inject constructor() : ShoppingListDataSource {
    override fun getShoppingLists(): LiveData<Event<PagedList<ShoppingListModel>>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}