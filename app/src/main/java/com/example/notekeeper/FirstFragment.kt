package com.example.notekeeper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Create an instance of DataManager
        val dm = DataManager()

        // Create an adapter for the spinner to represent courses
        val adapterCourses = ArrayAdapter<CourseInfo>(
            requireActivity().baseContext,
            android.R.layout.simple_spinner_item,
            dm.courses.values.toList())

        // Set the adapters dropdown layout
        adapterCourses.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Assign the adapter to the spinner's adapter property
        spinnerCourses.adapter = adapterCourses
        

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}