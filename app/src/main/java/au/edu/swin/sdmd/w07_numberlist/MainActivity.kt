package au.edu.swin.sdmd.w07_numberlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showNumbersList(100)
    }

    fun showNumbersList(maxSize: Int){
        val numberList = findViewById<RecyclerView>(R.id.numberList)

        val data = IntArray(maxSize) { it }.filter { it % 3 == 0 || it % 5 == 0 }

        numberList.adapter = NumberAdapter(data)
        numberList.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.number_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Handle item selection
        return when (item.itemId){
            R.id.low_limit -> {
                showNumbersList(20)
                true
            }
            R.id.medium_limit->{
                showNumbersList(50)
                true
            }
            R.id.high_limit->{
                showNumbersList(100)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}