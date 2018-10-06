package com.aleksej.makaji.listopia.data.room

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aleksej.makaji.listopia.data.room.model.ShoppingList

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Dao
interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoppingList(shoppingList: ShoppingList)

    @Query("SELECT * FROM shopping_list")
    fun getShoppingLists(): DataSource.Factory<Int, ShoppingList>
}