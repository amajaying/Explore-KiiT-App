package com.example.kiitappwithinstaclone

import android.app.Activity
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappwithinstaclone.databinding.ActivityAccountSettingsBinding
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.Menu
import android.widget.PopupMenu
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.profile_info_part.view.*
import kotlinx.android.synthetic.main.profile_pp_nam.view.*


class AccountSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAccountSettingsBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    //Image uri
    private var imageUri:Uri?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()


        binding.saveChanges.setOnClickListener {

        }

        binding.changeImage.setOnClickListener {
            showImageAttachMenu()
        }

        binding.backButton.setOnClickListener {
            onBackPressed()
        }

        binding.gotoPortal.setOnClickListener {
            val uri = Uri.parse("https://kiitportal.kiituniversity.net/irj/portal/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
    }

    private fun loadUserInfo() {
        val ref =FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val address = "${snapshot.child("address").value}"
                    val fullname = "${snapshot.child("address").value}"
                    val image = "${snapshot.child("image").value}"
                    val phoneNo = "${snapshot.child("phoneNo").value}"
                    val rollNo = "${snapshot.child("rollNo").value}"
                    val school = "${snapshot.child("school").value}"
                    val semester = "${snapshot.child("semester").value}"

                    //set Data

                   binding.editname.setText(fullname)
                   binding.editname.setText(fullname)

                    //settingimage
                    try {
                        Glide.with(this@AccountSettingsActivity)
                            .load(image)
                            .placeholder(R.drawable.default_profile)
                            .into(binding.editProfilePp)
                    }
                    catch (e: Exception){

                    }

                }

                override fun onCancelled(error: DatabaseError) {

                }
            })

    }


    private fun showImageAttachMenu(){
        val popupMenu = PopupMenu(this, binding.editProfilePp)
        popupMenu.menu.add(Menu.NONE, 0, 0, "Camera")
        popupMenu.menu.add(Menu.NONE, 1, 1, "Gallery")
        popupMenu.show()

        popupMenu.setOnMenuItemClickListener { item ->
            val id = item.itemId

            if (id==0) {
            //camera clicked
                pickImageCamera()

            }
            else if (id==1) {
                //gallery clicked
                pickImageGallery()

            }
            true
        }
    }

    private fun pickImageGallery() {

    }

    private fun pickImageCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "Temp_Title")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Temp_Description")

        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        cam
    }

    private var cameraActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data =result.data
                imageUri = data!!.data


                 binding.changeImage.setImageURI(imageUri)
            }
            else{
                
            }
        }
    )
}