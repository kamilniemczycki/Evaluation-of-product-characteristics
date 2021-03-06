package pl.memstacja.bottomnavigation.ui.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.memstacja.bottomnavigation.R

class PartsOpen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Produkty"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parts)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val name: String? = intent.getStringExtra("listName")
        val description: String? = intent.getStringExtra("listDescription")

        findViewById<TextView>(R.id.listName).text = name
        findViewById<TextView>(R.id.listDescription).text = description

        Log.d("ACTIVE_APP", "$name $description")

        val featuresList = findViewById<RecyclerView>(R.id.viewGroup)

        setToList(featuresList)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun generateList(): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()

        for (i in 1..5){
            val item = ExampleItem(
                "Produkt ${i.toString()}",
                "Opis cechy: ${i.toString()}"
            )

            list += item
        }

        return list
    }

    private fun setToList(recyclerView: RecyclerView) {

        val generatedList: List<ExampleItem> = generateList()
        recyclerView.adapter = PartsAdapter(generatedList.reversed())
        recyclerView.layoutManager = LinearLayoutManager(this@PartsOpen)
        recyclerView.setHasFixedSize(true)
    }
}