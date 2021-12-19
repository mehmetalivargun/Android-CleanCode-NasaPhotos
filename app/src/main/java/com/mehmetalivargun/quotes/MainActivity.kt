package com.mehmetalivargun.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mehmetalivargun.core.ui.BaseActivity
import com.mehmetalivargun.core.ui.BaseViewModel
import com.mehmetalivargun.quotes.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    override val viewModel: BaseViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}