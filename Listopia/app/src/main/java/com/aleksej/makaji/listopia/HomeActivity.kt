package com.aleksej.makaji.listopia

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.aleksej.makaji.listopia.base.BaseActivity
import com.aleksej.makaji.listopia.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
    }
}
