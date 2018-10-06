package com.aleksej.makaji.listopia.screen.shoppinglist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import com.aleksej.makaji.listopia.R
import com.aleksej.makaji.listopia.base.BaseFragment
import com.aleksej.makaji.listopia.data.event.ErrorEvent
import com.aleksej.makaji.listopia.data.event.LoadingEvent
import com.aleksej.makaji.listopia.data.event.SuccessEvent
import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel
import timber.log.Timber

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListFragment: BaseFragment() {

    private lateinit var mShoppingListViewModel: ShoppingListViewModel

    private var mObserversInitialized = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_shopping_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mShoppingListViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ShoppingListViewModel::class.java)

        if (!mObserversInitialized) {
            observe()
            mObserversInitialized = true
        }
    }

    private fun observe() {
        mShoppingListViewModel.shoppingListsEvent.observe(this, Observer {
            when (it) {
                is SuccessEvent<PagedList<ShoppingListModel>> -> {
                    showToast("SIZEEEEEE: " + it.data?.size)
                }
                is LoadingEvent -> {
                }
                is ErrorEvent<PagedList<ShoppingListModel>> -> {
                    showToast("ERROR load + " + it.error)
                }
            }
        })
    }
}