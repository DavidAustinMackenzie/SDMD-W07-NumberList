package au.edu.swin.sdmd.w07_numberlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class NumberAdapter(private val data: List<Int>) : RecyclerView.Adapter<NumberAdapter.ViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.layout_row, parent, false) as View
        return ViewHolder(view)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: NumberAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    inner class ViewHolder(private val v: View) : RecyclerView.ViewHolder(v) {
        private val number: TextView = v.findViewById(R.id.number)

        //Setup the view in each row
        fun bind(item: Int) {
            number.text = item.toString()

            v.setOnClickListener{
                val i = Intent(it.context,DetailActivity::class.java)
                i.putExtra("NUMBER",item)
                it.context.startActivity(i)
            }
        }
    }
}