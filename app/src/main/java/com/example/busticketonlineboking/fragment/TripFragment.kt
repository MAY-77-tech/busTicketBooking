package com.example.busticketonlineboking.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.adapter.TripAdapter
import com.example.busticketonlineboking.model.Trip
import com.example.busticketonlineboking.viewModel.CarInformationViewModel
import kotlinx.android.synthetic.main.fragment_trip.*

class TripFragment : Fragment(),TripAdapter.ClickListener {

    private lateinit var viewModel: CarInformationViewModel
    private lateinit var viewManager  : RecyclerView.LayoutManager
    private var tripAdapter: TripAdapter=TripAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(this.context)
        recycler.apply {
            layoutManager = viewManager
            adapter =tripAdapter
            obserViewModel()
        }


    }

    private fun obserViewModel(){
    viewModel = ViewModelProvider(this).get(CarInformationViewModel::class.java)
        viewModel.tripInformation.observe(viewLifecycleOwner, Observer{
            recycler.visibility = View.VISIBLE
            tripAdapter.updateList(it)
            tripAdapter.setClickListener(this)
            Log.d("UpdateList>>>>",it.toString())
        }
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTrip()
    }

    override fun onClickTripAdapter(tripResultList: Trip) {
Log.e("Trip>>>>",tripResultList.class_name )
        if(tripResultList.class_name== "VIP"){
            findNavController().navigate(R.id.action_tripFragment_to_vipFragment2)
        }else{
            findNavController().navigate(R.id.action_tripFragment_to_standardFragment22)
        }
    }


}