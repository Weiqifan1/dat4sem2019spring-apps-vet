package dk.cphbusiness.vetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_rest.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.uiThread
import java.net.URL
import java.net.URLEncoder

//class Request(val url: String) {
//    fun run(url: String) {
//        val result = URL(url).readText()
//        Log.d("PETS", result)
//        }
//    }

class RestActivity : AppCompatActivity() {
    val cphUrl = "https://openweathermap.org/city/2618425"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest)
        get_button.onClick {
            doAsync {
                // Request(cphUrl).run()
                val result = URL(cphUrl).readText()
                uiThread {
                    // longToast("Done")
                    result_text.setText(result)
                    }
                }
            }
        }

    }

class X {
        val url = "http://example.com"
        val charset = "UTF-8"
        val param1 = URLEncoder.encode("value1", charset)
        val param2 = URLEncoder.encode("value2", charset)

        val query = "param1=$param1&param2=$param2"

    fun get() {
        val connection = URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", charset);
        val response = connection.inputStream;
        }

    fun post() {

        }
    }