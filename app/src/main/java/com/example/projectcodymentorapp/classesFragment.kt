package com.example.projectcodymentorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_students.*



/**
 * A simple [Fragment] subclass.
 * Use the [classesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class classesFragment : Fragment() {
    lateinit var viewManager: LinearLayoutManager
    lateinit var viewAdapter: CourseRecyclerViewAdapter

    val viewModel: EntryViewModel by activityViewModels<EntryViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_classes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewManager = LinearLayoutManager(this.context)

        // handles the clicking event in the recyclerView
        val clickLambda: (Course) -> Unit = {
            viewModel.currentEntry.postValue(it)
            findNavController().navigate(R.id.action_menuClasses_to_enrolledCourseFragment)

        }
        viewAdapter = CourseRecyclerViewAdapter(ArrayList())
        viewAdapter.clickLambda = clickLambda

        students_recycler?.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        viewModel.entryList.observe(viewLifecycleOwner, Observer {
            viewAdapter.courseData = viewModel.getCourses()
            viewAdapter.notifyDataSetChanged()

        })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment classesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            classesFragment().apply {

            }
    }
}