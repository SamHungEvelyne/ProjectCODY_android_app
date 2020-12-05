package com.example.projectcodymentorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_enrolled_course.*


/**
 * A simple [Fragment] subclass.
 * Use the [enrolledCourseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class enrolledCourseFragment : Fragment() {

    val viewModel: EntryViewModel by activityViewModels<EntryViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enrolled_course, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var course = viewModel.currentEntry.value as Course

        name_text.text = course.name
        title_text.text = course.title
        mentor_text.text = course.mentor
        cap_text.text = course.cap.toString()
        description_text.text = course.description

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment enrolledCourseFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            enrolledCourseFragment().apply {

            }
    }
}