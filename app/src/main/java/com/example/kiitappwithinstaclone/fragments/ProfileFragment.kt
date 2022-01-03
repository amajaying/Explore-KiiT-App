package com.example.kiitappwithinstaclone.fragments

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kiitappwithinstaclone.AccountSettingsActivity
import com.example.kiitappwithinstaclone.LoginActivity
import com.example.kiitappwithinstaclone.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.core.Context
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.activity_signup.view.*
import kotlinx.android.synthetic.main.fragment_profile2.view.*
import kotlinx.android.synthetic.main.profile_info_part.view.*
import kotlinx.android.synthetic.main.profile_info_part.view.address
import kotlinx.android.synthetic.main.profile_pp_nam.view.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ProfileFragment : Fragment() {

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


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile2, container, false)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()


        view.edit_profile.setOnClickListener{
            startActivity(Intent(context,AccountSettingsActivity::class.java))
        }

        view.logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()


            val intent = Intent(context, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }


        return view



    }

    private fun loadUserInfo() {
        val ref =FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val address = "${snapshot.child("address").value}"
                    val email = "${snapshot.child("email").value}"
                    val fullname = "${snapshot.child("address").value}"
                    val image = "${snapshot.child("image").value}"
                    val phoneNo = "${snapshot.child("phoneNo").value}"
                    val rollNo = "${snapshot.child("rollNo").value}"
                    val school = "${snapshot.child("school").value}"
                    val semester = "${snapshot.child("semester").value}"
                    val uid = "${snapshot.child("uid").value}"

                    //set Data

                    view!!.student_name.text = fullname
                    view!!.roll_no.text = rollNo
                    view!!.address.text = address
                    view!!.contactNo.text = phoneNo
                    view!!.schoolinfo.text = school
                    view!!.semester.text = semester

                    //settingimage
                    try {
                        Glide.with(this@ProfileFragment)
                            .load(image)
                            .placeholder(R.drawable.default_profile)
                            .into(view!!.profileImg)
                    }
                    catch (e: Exception){

                    }

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
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}