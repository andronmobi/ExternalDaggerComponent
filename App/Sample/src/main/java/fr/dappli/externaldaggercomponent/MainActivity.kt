package fr.dappli.externaldaggercomponent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import fr.dappli.externaldaggercomponent.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private companion object {
        const val TAG = "MainActivity"
    }

    private lateinit var  binding: ActivityMainBinding
    private lateinit var callbackManager: CallbackManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()
        binding.loginButton.apply {
            setPermissions(listOf("email"))
            registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

                override fun onSuccess(result: LoginResult?) {
                    Log.d(TAG, "onSuccess: $result")
                }

                override fun onCancel() {
                    Log.w(TAG, "onCancel")
                }

                override fun onError(error: FacebookException?) {
                    Log.e(TAG, "onError: $error")
                }

            })
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
