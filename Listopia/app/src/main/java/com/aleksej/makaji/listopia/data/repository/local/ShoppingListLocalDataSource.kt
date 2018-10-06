package com.aleksej.makaji.listopia.data.repository.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.aleksej.makaji.listopia.data.event.Event
import com.aleksej.makaji.listopia.data.event.SuccessEvent
import com.aleksej.makaji.listopia.data.maper.RoomModelMapper
import com.aleksej.makaji.listopia.data.repository.ShoppingListDataSource
import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel
import com.aleksej.makaji.listopia.data.room.ShoppingListDao
import com.aleksej.makaji.listopia.data.room.model.ShoppingList
import kotlinx.coroutines.experimental.async
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Singleton
class ShoppingListLocalDataSource @Inject constructor(private val mShoppingListDao: ShoppingListDao) : ShoppingListDataSource {

    companion object {
        private const val PAGED_LIST_PAGE_SIZE = 12
        private const val PAGED_LIST_ENABLE_PLACEHOLDERS = true
    }

    override fun getShoppingLists(): LiveData<Event<PagedList<ShoppingListModel>>> {
        /*async {
            mShoppingListDao.insertShoppingList(ShoppingList(1, "Name-1"))
            mShoppingListDao.insertShoppingList(ShoppingList(2, "Name-2"))
            mShoppingListDao.insertShoppingList(ShoppingList(3, "Name-3"))
            mShoppingListDao.insertShoppingList(ShoppingList(4, "Name-4"))
        }*/

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(PAGED_LIST_ENABLE_PLACEHOLDERS)
                .setPageSize(PAGED_LIST_PAGE_SIZE)
                .build()

        val tempLiveData = MutableLiveData<Event<PagedList<ShoppingListModel>>>()

        val livePagedListOrder = LivePagedListBuilder(mShoppingListDao.getShoppingLists().map {
            RoomModelMapper.mapShoppingList(it)
        }, pagedListConfig)
                .build()

        return Transformations.switchMap(livePagedListOrder) {
            tempLiveData.postValue(SuccessEvent(it))
            return@switchMap tempLiveData
        }
    }
}