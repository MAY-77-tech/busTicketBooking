package com.example.busticketonlineboking.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.model.TripX
import kotlinx.android.synthetic.main.item_car_information.view.*

class RouteAdapter:RecyclerView.Adapter<RouteAdapter.TripViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setClickListener(clickListener: ClickListener) {
        this.mClickListener = clickListener
    }

    var tripResultList: List<TripX> = listOf()

    inner class TripViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{

        private lateinit var result: TripX

        init {
            itemView.select_seat_btn.setOnClickListener(this)//initialize onClick fun:s and/ when start create obj,it works
        }
        fun bindTripData(result: TripX){
            this.result = result
            itemView.available_car_time.text = result.departure_time
            itemView.departure_time1.text = result.departure_time
            itemView.arrival_time1.text = result.arrival_time
            itemView.price.text = result.foregin_price
            itemView.available_car_class.text = result.class_name
//            itemView.route.text = result.route_id.from.city
//            itemView.route1.text ="to   ${result.route_id.to.city}"
            Log.d("Price>>>>",result.route_id.toString())

        }

        override fun onClick(p0: View?) {
            mClickListener?.onClickTripAdapter(result)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_car_information,parent,false)
        return TripViewHolder(view)
    }

    override fun getItemCount(): Int {
            return tripResultList.size
    }

    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        holder.bindTripData(tripResultList[position])
        Log.d("Position>>>",position.toString())

    }

    fun  updateList(result: List<TripX>){
        this.tripResultList = result
        Log.d("Result>>>>",result.toString())
        notifyDataSetChanged()
    }

    interface ClickListener {
        fun onClickTripAdapter(tripResultList : TripX)
    }

}