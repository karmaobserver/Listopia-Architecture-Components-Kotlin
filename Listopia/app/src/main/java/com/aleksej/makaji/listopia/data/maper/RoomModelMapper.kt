package com.aleksej.makaji.listopia.data.maper

import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel
import com.aleksej.makaji.listopia.data.room.model.ShoppingList

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
object RoomModelMapper {
    fun mapShoppingList(shoppingList: ShoppingList): ShoppingListModel {
        return ShoppingListModel(shoppingList.id,
                shoppingList.name)
    }
}