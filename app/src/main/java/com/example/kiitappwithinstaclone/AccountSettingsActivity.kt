package com.example.kiitappwithinstaclone

import android.app.Activity
import android.app.ProgressDialog
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kiitappwithinstaclone.databinding.ActivityAccountSettingsBinding
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.Menu
import android.widget.PopupMenu
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage.*
import kotlinx.android.synthetic.main.activity_signup.*
import kotlinx.android.synthetic.main.profile_info_part.view.*
import kotlinx.android.synthetic.main.profile_pp_nam.view.*


class AccountSettingsActivity : AppCompatActivity() {
    //binding
    private lateinit var binding: ActivityAccountSettingsBinding

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    //Image uri
    private var imageUri: Uri? = null

    //progress dialog
    private lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAccountSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setting up Progress Dialog
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please Wait!")
        progressDialog.setCanceledOnTouchOutside(false)


        //for firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        loadUserInfo()


        binding.saveChanges.setOnClickListener {
            validateData()

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

    private var name = ""
    private var roll = ""
    private var sem = ""
    private var contact = ""
    private var address = ""

    private fun validateData(){
        name = binding.editname.text.toString().trim()
        roll = binding.editroll.text.toString().trim()
        sem = binding.editsem.text.toString().trim()
        contact = binding.editcontact.text.toString().trim()
        address = binding.editaddress.text.toString().trim()

        if (name.isEmpty()){
            Toast.makeText(this, "Enter Full Name", Toast.LENGTH_SHORT).show()
        }

        else if (roll.isEmpty()){
            Toast.makeText(this, "Enter Roll No.", Toast.LENGTH_SHORT).show()
        }

        else if (sem.isEmpty()){
            Toast.makeText(this, "Enter current Semester", Toast.LENGTH_SHORT).show()
        }

        else if (contact.isEmpty()){
            Toast.makeText(this, "Enter Contact No.", Toast.LENGTH_SHORT).show()
        }

        else if (address.isEmpty()){
            Toast.makeText(this, "Enter Address", Toast.LENGTH_SHORT).show()
        }


        else{
            if (imageUri==null){
                updateProfile("")
            }
            else{
                uploadImage()
            }

        }
    }

    private fun uploadImage() {
        progressDialog.setMessage("Uploading profile picture")
        progressDialog.show()

        val filePathAndName = "ProfileImages/"+firebaseAuth.uid

        val reference = getInstance().getReference(filePathAndName)
        reference.putFile(imageUri!!)
            .addOnSuccessListener{ taskSnapshot ->
                val uriTask: Task<Uri> = taskSnapshot.storage.downloadUrl
//                while (!uriTask.isSuccessful);
                val uploadedImageUrl = "${uriTask.result}"

                updateProfile(uploadedImageUrl)

            }
            .addOnFailureListener{e ->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed to upload image due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun updateProfile(uploadedImageUrl: String) {
        progressDialog.setMessage("Saving Changes...")

        val hashmap: HashMap<String, Any> = HashMap()
        hashmap["fullname"] = name
        hashmap["rollNo"] = roll
        hashmap["semester"] = sem
        hashmap["phoneNo"] = contact
        hashmap["address"] = address
        if (imageUri!=null){
            hashmap["image"] = uploadedImageUrl
        }

        val reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(firebaseAuth.uid!!)
            .updateChildren(hashmap)
            .addOnSuccessListener {
                progressDialog.dismiss()
                Toast.makeText(this, "Profile Updated!", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {e->
                progressDialog.dismiss()
                Toast.makeText(this, "Failed to update profile due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun loadUserInfo() {
        val ref =FirebaseDatabase.getInstance().getReference("Users")
        ref.child(firebaseAuth.uid!!)
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val address = "${snapshot.child("address").value}"
                    val fullname = "${snapshot.child("fullname").value}"
                    val image = "${snapshot.child("image").value}"
                    val phoneNo = "${snapshot.child("phoneNo").value}"
                    val rollNo = "${snapshot.child("rollNo").value}"
//                    val school = "${snapshot.child("school").value}"
                    val semester = "${snapshot.child("semester").value}"

                    //set Data

                   binding.editname.setText(fullname)
                   binding.editaddress.setText(address)
                   binding.editcontact.setText(phoneNo)
                   binding.editroll.setText(rollNo)
                   binding.editsem.setText(semester)

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
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryActivityResultLauncher.launch(intent)

    }

    private fun pickImageCamera() {
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "Temp_Title")
        values.put(MediaStore.Images.Media.DESCRIPTION, "Temp_Description")

        imageUri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)

        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri)
        cameraActivityResultLauncher.launch(intent)
    }

    private var cameraActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> {result ->
            if(result.resultCode == Activity.RESULT_OK){
                val data =result.data



                binding.editProfilePp.setImageURI(imageUri)
            }
            else{
                Toast.makeText(this,"Cancelled", Toast.LENGTH_SHORT).show()
            }
        }
    )

    private var galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            imageUri = data!!.data


            binding.editProfilePp.setImageURI(imageUri)
        } else {
            Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show()
        }
    }
}