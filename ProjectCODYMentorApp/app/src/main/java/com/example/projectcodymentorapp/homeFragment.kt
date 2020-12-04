package com.example.projectcodymentorapp

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.material.theme.MaterialComponentsViewInflater

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [homeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class homeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // sets the default action bar title to "" so the app can keep its name below logo in phone's home screen
        (activity as AppCompatActivity).supportActionBar?.title = ""

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
        // indicating that this fragment has options menu (i.e, the toolbar)
        setHasOptionsMenu(true)


    }
    // view for HomeFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflating the toolbar for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // setting the actionBar to be the toolbar
        val homeToolbar = view.findViewById<Toolbar>(R.id.home_toolbar)
        (requireActivity() as AppCompatActivity).setSupportActionBar(homeToolbar)

//         returning view for the root view
        return view


    }



    // inflating the layout for this fragment
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    /* TESTING FOR ACTIONBAR BUTTONS - TO BE IMPLEMENTED BU HUNG & SAM
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings_topbar || item.itemId == R.id.logout_topbar) {
            Toast.makeText(requireActivity(), "It works!", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }




    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment homeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            homeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
