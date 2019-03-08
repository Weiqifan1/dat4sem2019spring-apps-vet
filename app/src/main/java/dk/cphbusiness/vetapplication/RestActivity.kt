package dk.cphbusiness.vetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_rest.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.uiThread
import java.net.URL
import java.net.URLEncoder
import java.nio.charset.Charset
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject


//class Request(val url: String) {
//    fun run(url: String) {
//        val result = URL(url).readText()
//        Log.d("PETS", result)
//        }
//    }

val petUrl = "http://624c0154.ngrok.io/pets"
val gson = Gson()

class PetListType : TypeToken<ArrayList<Pet>>()

fun getPets(): List<Pet> {
    val result = URL(petUrl).readText()
    val jsonList = JSONArray(result)
    val pets = mutableListOf<Pet>()
    for (index in 0..jsonList.length() - 1) {
        val jsonPet: JSONObject = jsonList[index] as JSONObject
        pets.add(
            Pet(
                jsonPet.getInt("id"),
                jsonPet.getString("name"),
                jsonPet.getBoolean("alive")
                )
            )
        }
//    val petListType = PetListType().type
//    return gson.fromJson<ArrayList<Pet>>(result, petListType::class.java)
    return pets
    }

class RestActivity : AppCompatActivity() {
    val cphUrl = "https://openweathermap.org/city/2618425"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rest)
        get_button.onClick {
            doAsync {
                // Request(cphUrl).run()
                // val result = URL(petUrl).readText()
                val pets = getPets()

                uiThread {
                    // longToast("Done")
                    result_text.text.clear()
                    pets.forEach { result_text.text.appendln(it.description) }
                    }
                }
            }
        }

    }

class X {
        val url = "http://example.com"
        val UTF8 = "UTF-8"
        val utf8 = Charsets.UTF_8
        val param1 = URLEncoder.encode("value1", UTF8)
        val param2 = URLEncoder.encode("value2", UTF8)

        val query = "param1=$param1&param2=$param2"

    fun get() {
        val connection = URL(url + "?" + query).openConnection();
        connection.setRequestProperty("Accept-Charset", UTF8);
        val response = connection.inputStream;
        }

    fun post() {
        val connection = URL(url).openConnection()
        connection.doOutput = true // Triggers POST.
        connection.setRequestProperty("Accept-Charset", UTF8)
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=$UTF8")
        connection.getOutputStream().use {
            output -> output.write(query.toByteArray(utf8))
            }
        val response = connection.getInputStream()
        }
    }