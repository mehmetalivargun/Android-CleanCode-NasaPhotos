package com.mehmetalivargun.core.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.core.view.allViews
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import com.mehmetalivargun.core.R
import com.mehmetalivargun.core.databinding.ActivityBaseBinding
import com.mehmetalivargun.core.databinding.LayoutErrorBinding
import com.mehmetalivargun.core.domain.ErrorPageViewState

abstract class BaseActivity <DB: ViewDataBinding>(@LayoutRes private val layoutRes: Int) : AppCompatActivity() {
    abstract val viewModel: BaseViewModel?
    lateinit var  binding: DB
    private val rootBinding: ActivityBaseBinding by lazy {
        setContentView(this, R.layout.activity_base)
    }
    private val errorBinding: LayoutErrorBinding by lazy {
        LayoutErrorBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.inflate(
            layoutInflater,
            layoutRes,
            rootBinding.content,
            true
        )
        binding.lifecycleOwner=this
        rootBinding.lifecycleOwner=this
        viewModel?.errorData?.observe(this){
            showError(it)
        }

    }

    fun showError(errorViewState: ErrorPageViewState){
        errorBinding.apply {
            rootBinding.error.addView(root)
            errorText.text = errorViewState.getExceptionMessage(root.context)
            retry.setOnClickListener {
                errorViewState.retryFunc()
                hideError()
            }
        }
    }
    fun hideError() {
        with(rootBinding.error) {
            if (allViews.count() != 0) {
                removeView(errorBinding.root)
            }
        }
    }
}