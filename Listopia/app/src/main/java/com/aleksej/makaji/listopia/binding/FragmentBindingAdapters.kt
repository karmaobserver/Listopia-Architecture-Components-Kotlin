package com.aleksej.makaji.listopia.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */

/**
 * Binding adapters that work with a fragment instance.
 */
class FragmentBindingAdapters {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            Glide.with(imageView.context)
                    .load(url)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(imageView)
        }
        //Glide.with(fragment).load(url).into(imageView)
    }
}