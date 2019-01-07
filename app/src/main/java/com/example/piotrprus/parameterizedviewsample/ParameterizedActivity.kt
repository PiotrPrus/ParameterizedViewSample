package com.example.piotrprus.parameterizedviewsample

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.piotrprus.parameterizedviewsample.databinding.ActivityParameterizedBinding
import com.example.piotrprus.parameterizedviewsample.utils.EventObserver

class ParameterizedActivity : AppCompatActivity() {

    companion object {
        const val INTENT_PARAMS = "INTENT_PARAMS"

        fun start(context: Context, params: Params) {
            val intent = Intent(context, ParameterizedActivity::class.java)
            intent.putExtra(INTENT_PARAMS, params)
            context.startActivity(intent)
        }
    }

    private lateinit var binding: ActivityParameterizedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_parameterized)
        binding.setLifecycleOwner(this)
        val viewModel = ViewModelProviders.of(this).get(ParameterizedViewModel::class.java)
        binding.viewModel = viewModel
        val params: Params = intent.extras?.getParcelable(INTENT_PARAMS)!!
        viewModel.bind(params)
        viewModel.mainButtonClickEvent.observe(this, EventObserver { params.mainOnClick().invoke(this) })
        viewModel.secondaryButtonClickEvent.observe(this, EventObserver { params.secondaryOnClick().invoke(this) })
    }
}