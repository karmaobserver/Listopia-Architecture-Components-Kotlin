package com.aleksej.makaji.listopia.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * Created by Aleksej Makaji on 10/6/18.
 */
open class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector, LifecycleOwner {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    // Todo redundant?
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector
}