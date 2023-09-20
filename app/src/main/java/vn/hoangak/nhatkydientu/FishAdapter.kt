package vn.hoangak.nhatkydientu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FishAdapter constructor(private val getActivity: FishYieldActivity, private val fishList: List<Fish>): RecyclerView.Adapter<FishAdapter.ViewHolder>(){
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Tham chiếu đến các view trong item_device.xml
        val fishName: TextView = itemView.findViewById(R.id.fishName)
        val fishQuantity: TextView = itemView.findViewById(R.id.fishQuantity)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FishAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_fish, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FishAdapter.ViewHolder, position: Int) {
        holder.fishName.text=fishList[position].fishName
        holder.fishQuantity.text= fishList[position].fishQuantity.toString()
    }

    override fun getItemCount(): Int = fishList.size
}