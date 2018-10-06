package com.aleksej.makaji.listopia.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.aleksej.makaji.listopia.data.room.model.ShoppingList

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
@Database(entities = [ShoppingList::class], version = 1)
@TypeConverters(Converters::class)
abstract class ListopiaDatabase : RoomDatabase() {
    abstract fun shoppingListDao() : ShoppingListDao
}