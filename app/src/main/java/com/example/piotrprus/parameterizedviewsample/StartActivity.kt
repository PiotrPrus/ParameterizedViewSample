package com.example.piotrprus.parameterizedviewsample

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_start.*


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        openFirst.setOnClickListener { startFirstActivity() }
        openSecond.setOnClickListener { startSecondActivity() }
        openThird.setOnClickListener { startThirdActivity() }
    }

    private fun startFirstActivity() {
        ParameterizedActivity.start(this, Params.create(
            R.drawable.ic_success,
            "Success",
            "You finished registration process!",
            "Cancel",
            "OK",
            { context -> goBack(context) },
            { context -> Toast.makeText(context, "This is great success)", Toast.LENGTH_SHORT).show() }
        ))
    }

    private fun startSecondActivity() {
        ParameterizedActivity.start(this, Params.create(
            R.drawable.ic_wifi,
            "No internet",
            "Please check your wifi/mobile connection",
            "Cancel",
            "Settings",
            { context -> goBack(context) },
            { context -> openSettings(context) }
        ))
    }

    private fun startThirdActivity() {
        ParameterizedActivity.start(this, Params.create(
            R.drawable.ic_battery,
            "Low battery",
            "Please charge the batteries",
            "Cancel",
            "Show chargers",
            { context -> goBack(context) },
            { context -> openMap(context) }
        ))
    }

    companion object {
        private fun goBack(context: Context) {
            val intent = Intent(context, StartActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        private fun openSettings(context: Context) {
            val intent = Intent(android.provider.Settings.ACTION_WIFI_SETTINGS)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        private fun openMap(context: Context) {
            val mapUri = Uri.parse("geo:0,0?q=tesla supercharger")
            val mapIntent = Intent(Intent.ACTION_VIEW, mapUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            context.startActivity(mapIntent)
        }
    }
}