package dk.cphbusiness.vetapplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class VetBaseOpenHelper(context: Context) :
    ManagedSQLiteOpenHelper(context, "VetBase", null, 1) {
    companion object {
        private var instance: VetBaseOpenHelper? = null

        @Synchronized
        fun getInstance(context: Context): VetBaseOpenHelper {
            if (instance == null) {
                instance = VetBaseOpenHelper(context.getApplicationContext())
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable("Pets", true,
            "id" to INTEGER + PRIMARY_KEY + UNIQUE,
            "name" to TEXT,
            "alive" to INTEGER
            )
        db.insert("Pets",
            "id" to 1,
            "name" to "Felix",
            "alive" to 1
            )
        db.insert("Pets",
            "id" to 2,
            "name" to "Rufus",
            "alive" to 1
            )
        db.insert("Pets",
            "id" to 3,
            "name" to "Killer",
            "alive" to 1
            )

        }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable("Pets", true)
        }



    }

val Context.database: VetBaseOpenHelper
    get() = VetBaseOpenHelper.getInstance(applicationContext)

val petParser = rowParser { id: Int, name: String, alive: Int ->
    val pet = Pet(id, name)
    pet.alive = alive != 0
    pet
    }

