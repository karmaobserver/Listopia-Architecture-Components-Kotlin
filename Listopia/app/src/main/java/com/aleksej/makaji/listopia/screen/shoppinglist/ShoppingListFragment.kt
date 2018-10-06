package com.aleksej.makaji.listopia.screen.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.aleksej.makaji.listopia.R
import com.aleksej.makaji.listopia.base.BaseFragment

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListFragment: BaseFragment() {

    private lateinit var mShoppingListViewModel: ShoppingListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shopping_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mShoppingListViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ShoppingListViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        mShoppingListViewModel.testDagger()
    }
}