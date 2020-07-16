package com.example.busticketonlineboking.fragment

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.busticketonlineboking.R

import com.example.busticketonlineboking.viewModel.CityViewModel
//import com.mic.dateandtime.R
import kotlinx.android.synthetic.main.fragment_city.*
import java.util.*
import kotlin.collections.ArrayList

class CityFragment : Fragment() {

    lateinit var cityViewModel: CityViewModel
    lateinit var CitySpinner: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cityViewModel = ViewModelProvider(this).get(CityViewModel::class.java)
        cityViewModel.loadCity()

        val calendar = Calendar.getInstance()
        var year =calendar.get(Calendar.YEAR)
        var month = calendar.get(Calendar.MONTH)
        var day = calendar.get(Calendar.DAY_OF_MONTH)

        cityViewModel.getCity().observe(viewLifecycleOwner, Observer {
            var data:ArrayList<String> = ArrayList()

            it.loctions.forEach{
                data.add(0, it.city)
                city_spinner.adapter = context?.let {
                    ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        data  //data arraylist ko spinner mar bind
                    )
                }
                city_spinner1.adapter = context?.let {
                    ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        data  //data arraylist ko spinner mar bind
                    )
                }

            }
        }

        )

        city_spinner.onItemSelectedListener = object: AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                    Toast.makeText(context,city_spinner.selectedItem.toString(), Toast.LENGTH_LONG).show()
                }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(context,city_spinner.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }
        }

        city_spinner1.onItemSelectedListener = object: AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                Toast.makeText(context,city_spinner1.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(context,city_spinner1.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }
        }

        departure_date.setOnClickListener {
         var dpd=context?.let{
             it->DatePickerDialog(it,DatePickerDialog.OnDateSetListener { view, myear, mmonth, mday ->
             var m=mmonth+1
             departure_date.text=""+mday+"/"+m+"/"+myear
         },year,month,day

         )
         }
            if(dpd!=null){
                dpd.show()
            }
        }

        cityViewModel.getCity().observe(viewLifecycleOwner, Observer {
            var data:ArrayList<String> = ArrayList()

            it.loctions.forEach{
                data.add(0, it.city)
                city_spinner.adapter = context?.let {
                    ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        data  //data arraylist ko spinner mar bind
                    )
                }
                city_spinner1.adapter = context?.let {
                    ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        data  //data arraylist ko spinner mar bind
                    )
                }

            }
        }

        )

        city_spinner.onItemSelectedListener = object: AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                Toast.makeText(context,city_spinner.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(context,city_spinner.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }
        }

            var data:ArrayList<String> = arrayListOf("Local","Foreign")


                nationality_spinner.adapter = context?.let {
                    ArrayAdapter<String>(
                        it,
                        R.layout.support_simple_spinner_dropdown_item,
                        data  //data arraylist ko spinner mar bind
                    )
                }

        nationality_spinner.onItemSelectedListener = object: AdapterView.OnItemClickListener,AdapterView.OnItemSelectedListener {
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                Toast.makeText(context,nationality_spinner.selectedItem.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(context,nationality_spinner.selectedItem.toString(),Toast.LENGTH_LONG).show()
            }
        }

            search_btn.setOnClickListener {

    }
    }




}
