package dk.cphbusiness.vetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_database.*
import org.jetbrains.anko.db.select

class DatabaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_database)
        val dbPets = database.use {
            select("Pets").parseList(petParser)
            }
        db_pet_recycler.apply {
            adapter = PetRecyclerAdapter(dbPets)
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@DatabaseActivity)
            }
        }
    }
