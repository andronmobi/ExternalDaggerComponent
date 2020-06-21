package fr.dappli.externaldaggercomponent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import fr.dappli.externaldaggercomponent.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import okhttp3.Request


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
                    val accessToken: AccessToken = AccessToken.getCurrentAccessToken()

                    if (!accessToken.isExpired) {
                        Thread(Runnable {
                            Log.d(TAG, "request: ${accessToken.token}")
                            val url = "https://graph.facebook.com/100004275396778?fields=id,name&access_token=${accessToken.token}"
                            Log.d(TAG, "request: $url")
                            val client = OkHttpClient()
                            val request = Request.Builder().url(url).build()
                            val response = client.newCall(request).execute()
                            Log.d(TAG, "response: ${response.code} ${response.body?.string()}")
                        }).start()
                    }
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
