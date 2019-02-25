package dk.cphbusiness.vetapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        simple_list_button.onClick { startActivity<SimpleActivity>() }
        adapter_list_button.onClick { startActivity<AdapterActivity>() }
        recycle_view_button.onClick { startActivity<RecyclerActivity>() }
        recycler_db_button.onClick { startActivity<DatabaseActivity>() }
    }
}
