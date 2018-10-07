package com.aleksej.makaji.listopia.screen.shoppinglist

import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import com.aleksej.makaji.listopia.R
import com.aleksej.makaji.listopia.base.BaseFragment
import com.aleksej.makaji.listopia.data.event.ErrorEvent
import com.aleksej.makaji.listopia.data.event.LoadingEvent
import com.aleksej.makaji.listopia.data.event.SuccessEvent
import com.aleksej.makaji.listopia.data.repository.model.ShoppingListModel
import com.aleksej.makaji.listopia.databinding.FragmentShoppingListBinding
import com.aleksej.makaji.listopia.util.autoCleared
import kotlinx.android.synthetic.main.fragment_shopping_list.*
import timber.log.Timber

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
class ShoppingListFragment: BaseFragment() {

    private lateinit var mShoppingListViewModel: ShoppingListViewModel

    private var mObserversInitialized = false

    private var binding by autoCleared<FragmentShoppingListBinding>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val dataBinding = FragmentShoppingListBinding.inflate(inflater, container, false)
        binding = dataBinding
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mShoppingListViewModel = ViewModelProviders.of(this, mViewModelFactory).get(ShoppingListViewModel::class.java)

        if (!mObserversInitialized) {
            observe()
            mObserversInitialized = true
        }
    }

    override fun onStart() {
        super.onStart()
        (activity as AppCompatActivity).supportActionBar?.setTitle(R.string.title_shopping_list)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        menu?.clear()
        inflater?.inflate(R.menu.menu_fragment_shopping_list, menu)
    }

    private fun observe() {
        mShoppingListViewModel.shoppingListsEvent.observe(this, Observer {
            when (it) {
                is SuccessEvent<PagedList<ShoppingListModel>> -> {
                    binding.textViewTest.text = it.data?.get(0).toString()
                    showToast("SIZEEEEEE: " + it.data?.size)
                    Handler().postDelayed({
                        binding.loadingDotsShoppingList.visibility = View.INVISIBLE
                    }, 1000)

                }
                is LoadingEvent -> {
                    binding.loadingDotsShoppingList.visibility = View.VISIBLE
                }
                is ErrorEvent<PagedList<ShoppingListModel>> -> {
                    showToast("ERROR load + " + it.error)
                }
            }
        })
    }
}