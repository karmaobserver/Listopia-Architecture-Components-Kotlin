package com.aleksej.makaji.listopia.binding

import android.view.View
import androidx.databinding.BindingAdapter

/**
 * Created by Aleksej Makaji on 10/6/18.
 */

/**
 * Data Binding adapters specific to the app.
 */
object BindingAdapters {
    @JvmStatic
    @BindingAdapter("visibleGone")
    fun showHide(view: View, show: Boolean) {
        view.visibility = if (show) View.VISIBLE else View.GONE
    }
}