package com.example.kiitappver2.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.kiitappver2.AccountSettingsActivity
import com.example.kiitappver2.LoginActivity
import com.example.kiitappver2.R
import com.example.kiitappver2.databinding.FragmentProfile2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_attendance2.view.*
import kotlinx.android.synthetic.main.fragment_profile2.*
import kotlinx.android.synthetic.main.profile_attd_stats.view.*


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfile2Binding
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        binding = FragmentProfile2Binding.inflate(layoutInflater, container, false)


        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()


        binding.profileInfo.editProfile.setOnClickListener{
            startActivity(Intent(context,AccountSettingsActivity::class.java))
        }

        binding.logout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()


            val intent = Intent(context, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }


        binding.statsProfile.gotoPortal.setOnClickListener {
            val uri = Uri.parse("https://kiitportal.kiituniversity.net/irj/portal/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        return binding.root



    }

    private fun loadUserInfo() {
        val ref =FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val address = "${snapshot.child("address").value}"
                    val email = "${snapshot.child("email").value}"
                    val fullname = "${snapshot.child("fullname").value}"
                    val image = "${snapshot.child("image").value}"
                    val phoneNo = "${snapshot.child("phoneNo").value}"
                    val rollNo = "${snapshot.child("rollNo").value}"
                    val school = "${snapshot.child("school").value}"
                    val semester = "${snapshot.child("semester").value}"
                    val uid = "${snapshot.child("uid").value}"
                    val progress = "${snapshot.child("progress").value}"
                    val percent = "${snapshot.child("percent").value}"

                    //set Data

                    binding.profileInfo.studentName.text = fullname
                    binding.profileTop.studentName1.text = fullname
                    binding.profileInfo.rollNo.text = rollNo
                    binding.profileInfo.address.text = address
                    binding.profileInfo.contactNo.text = phoneNo
                    binding.profileInfo.schoolinfo.text = school
                    binding.profileInfo.semester.text = semester
                    binding.profileTop.semester1.text = semester
                    binding.statsProfile.circleProgress.percent.text = percent
                    binding.statsProfile.circleProgress.circularProgressBar.progress = progress.toFloat()

                    //setting image
                    try {
                        Glide.with(this@ProfileFragment)
                            .load(image)
                            .centerCrop()
                            .into(binding.profileTop.profileImg1)
                    }
                    catch (e: Exception){

                    }

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })
    }


}