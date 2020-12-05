package com.example.projectcodymentorapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_student.*


/**
 * A simple [Fragment] subclass.
 * Use the [studentFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class studentFragment : Fragment() {
    val viewModel: EntryViewModel by activityViewModels<EntryViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var student = viewModel.currentEntry.value as Student

        studentname_text.text = student.first_name
        parentemail_text.text = student.parent_email
        parentphone_text.text = student.parent_phone
        age_text.text = student.age_group
        background_text.text = student.programming_background
        sessions_text.text = student.sessions
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment studentFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            studentFragment().apply {

            }
    }
}