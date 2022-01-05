package com.example.kiitappver2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentAttendance2Binding
import com.example.kiitappver2.databinding.FragmentHome2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_attendance2.*
import kotlinx.android.synthetic.main.fragment_attendance2.view.*
import kotlinx.android.synthetic.main.fragment_attendance2.view.profileImg1
import kotlinx.android.synthetic.main.profile_pp_nam.view.*
import org.naishadhparmar.zcustomcalendar.CustomCalendar
import java.util.HashMap

import org.naishadhparmar.zcustomcalendar.Property


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AttendanceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AttendanceFragment : Fragment() {

    private var _binding: FragmentAttendance2Binding? = null

    private val binding get() = _binding!!

    private lateinit var firebaseAuth: FirebaseAuth
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAttendance2Binding.inflate(inflater, container, false)

        //Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()

        return binding.root
    }

    private fun loadUserInfo() {
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val name = "${snapshot.child("fullname").value}"
                    val semester = "${snapshot.child("semester").value}"
                    val attNo = "${snapshot.child("attNo").value}"
                    val progress = "${snapshot.child("progress").value}"
                    val percent = "${snapshot.child("percent").value}"
                    val uid = "${snapshot.child("uid").value}"
                    val image = "${snapshot.child("image").value}"

                    view!!.studentname.text = name
                    view!!.semester.text = semester
                    view!!.attNo.text = attNo
                    view!!.percent.text = percent
                    view!!.circularProgressBar.progress = progress.toFloat()



                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AttendanceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AttendanceFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}