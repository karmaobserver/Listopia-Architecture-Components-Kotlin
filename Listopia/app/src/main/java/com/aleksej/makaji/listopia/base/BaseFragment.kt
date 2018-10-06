package com.aleksej.makaji.listopia.base

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aleksej.makaji.listopia.R
import com.aleksej.makaji.listopia.di.Injectable
import com.aleksej.makaji.listopia.error.BackendError
import com.aleksej.makaji.listopia.error.ListopiaError
import com.aleksej.makaji.listopia.error.RoomError
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
open class BaseFragment : Fragment(), Injectable {

    @Inject
    lateinit var mViewModelFactory: ViewModelProvider.Factory

    fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun showToast(resourceId: Int) {
        showToast(getString(resourceId))
    }

    open fun showError(error: ListopiaError) {
        when(error){
            is BackendError -> {
                showToast(error.error.message)
            }
            is RoomError -> {
                showToast(R.string.error_room)
            }
        }
    }
}