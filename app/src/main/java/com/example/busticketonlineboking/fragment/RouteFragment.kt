package com.example.busticketonlineboking.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.busticketonlineboking.R
import com.example.busticketonlineboking.adapter.RouteAdapter
import com.example.busticketonlineboking.viewModel.RouteViewModel
import com.example.busticketonlineboking.viewModel.TripViewModel

class RouteFragment : Fragment() {

    private lateinit var routeViewModel: RouteViewModel
    private lateinit var viewManager  : RecyclerView.LayoutManager
    private var routeAdapter: RouteAdapter = RouteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_trip, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var data = arguments.let {  TripFragmentArgs.fromBundle(it!!)}




        //viewManager = LinearLayoutManager(this.context)


        //   obserViewModel(resultRouteId,resultDepartureTime)
    }

    private fun obserViewModel(routeId: Int,departureTime: String){
        routeViewModel = ViewModelProvider(this).get(RouteViewModel::class.java)
        routeViewModel.loadRoute()
        routeViewModel.getRoute().observe(viewLifecycleOwner, Observer {
            Log.d("data>>>>",it.toString())
//            routeAdapter.updateList(it)
        })

//        viewModel.tripInformation.observe(viewLifecycleOwner, Observer{
//            recycler.visibility = View.VISIBLE
//            tripAdapter.updateList(it)
//            tripAdapter.setClickListener(this)
//            Log.d("UpdateList>>>>",it.toString())
//        }
//        )
    }



}