package com.example.kiitappwithinstaclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import com.bumptech.glide.util.Util
import com.example.kiitappwithinstaclone.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.collections.HashMap as HashMap

class SignUP : AppCompatActivity() {

    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener {
            CreateAccount()
        }
    }

    private fun CreateAccount() {
        val fullname = binding.fullName.text.toString()
        val email = binding.emaill.text.toString()
        val password = binding.pass.text.toString()
        val rollNo = binding.rollN.text.toString()
        val phoneNo = binding.phoneNo.text.toString()
        val address = binding.address.text.toString()
        val school = binding.school.text.toString()
        val semester = binding.sem.text.toString()

        val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

        mAuth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) { task ->
                if(task.isSuccessful){
                    SaveuserInfo(fullname,email,phoneNo,rollNo,address,school,semester)
                }
                else{
                    val message = task.exception!!.toString()
                }


    }
}

    private fun SaveuserInfo(fullname: String, email: String, phoneNo: String, rollNo: String, address: String, school: String, semester: String) {
        val currentUserId = FirebaseAuth.getInstance().currentUser!!.uid
        val usersRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")

        val userMap = HashMap<String, Any>()
        userMap["uid"] = currentUserId
        userMap["fullname"] = currentUserId
        userMap["email"] = currentUserId
        userMap["phoneNo"] = currentUserId
        userMap["rollNo"] = currentUserId
        userMap["address"] = currentUserId
        userMap["school"] = currentUserId
        userMap["semester"] = currentUserId
        userMap["image"] = "gs://appfinalkiit.appspot.com/Default Images/default_profile.jpg"

        usersRef.child(currentUserId).setValue(userMap)

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
            }
    }
