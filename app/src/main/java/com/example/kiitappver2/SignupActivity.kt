package com.example.kiitappver2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kiitappver2.databinding.ActivitySignupBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener {
            createAccount()
        }
    }

    private fun createAccount() {
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
                    saveuserInfo(fullname,email,phoneNo,rollNo,address,school,semester)
                }
                else{
                    val message = task.exception!!.toString()
                }


            }
    }

    private fun saveuserInfo(fullname: String, email: String, phoneNo: String, rollNo: String, address: String, school: String, semester: String) {
        val currentUserId = FirebaseAuth.getInstance().currentUser!!.uid
        val usersRef: DatabaseReference = FirebaseDatabase.getInstance().reference.child("Users")

        val userMap = HashMap<String, Any>()
        userMap["uid"] = currentUserId
        userMap["fullname"] = fullname
        userMap["email"] = email
        userMap["phoneNo"] = phoneNo
        userMap["rollNo"] = rollNo
        userMap["address"] = address
        userMap["school"] = school
        userMap["semester"] = semester
        userMap["image"] = "gs://appfinalkiit.appspot.com/Default Images/default_profile.jpg"

        usersRef.child(currentUserId).setValue(userMap)

        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        finish()
    }
}
