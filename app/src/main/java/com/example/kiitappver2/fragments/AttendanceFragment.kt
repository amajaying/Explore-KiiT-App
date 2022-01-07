package com.example.kiitappver2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kiitappver2.databinding.FragmentAttendance2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class AttendanceFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var binding: FragmentAttendance2Binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAttendance2Binding.inflate(inflater, container, false)

        //Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()

        return binding.root
    }

    private fun loadUserInfo() {
        val ref = FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val fullname = "${snapshot.child("fullname").value}"
                    val semester = "${snapshot.child("semester").value}"
                    val attNo = "${snapshot.child("attNo").value}"
                    val progress = "${snapshot.child("progress").value}"
                    val percent = "${snapshot.child("percent").value}"
                    val uid = "${snapshot.child("uid").value}"
                    val image = "${snapshot.child("image").value}"

                    binding.studentname.text = fullname
                    binding.semester.text = semester
                    binding.attNo.text = attNo
                    binding.percent.text = percent
                    binding.circularProgressBar.progress = progress.toFloat()
//                    binding.profileImg1.setImageResource(image.toInt())

                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

    }

}