package com.example.kiitappver2.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.kiitappver2.*
import com.example.kiitappver2.databinding.FragmentHome2Binding
import com.example.kiitappver2.databinding.FragmentNoLoginHomeBinding
import com.google.firebase.auth.FirebaseAuth



class NoLoginHomeFragment : Fragment() {


   private lateinit var binding:FragmentNoLoginHomeBinding


    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = FragmentNoLoginHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment


        //Image Slder Start
        val imageSlider = binding.imageSlier
        val imageList = ArrayList<SlideModel>()


        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_four.png?alt=media&token=4bcf1fb3-717f-4d77-b902-c57ab24798b8"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_one.png?alt=media&token=3431cc5f-eece-45e0-9619-63c45eefc024"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_three.png?alt=media&token=b913792e-af40-46ba-bd11-cd7844bf48d4"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_two.png?alt=media&token=7e26353d-ab40-425b-a988-b6c9353445ac"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        //Image Slider Finish


        //Virtual Tour Button
        binding.virtualToutbtn.setOnClickListener{
            val uri = Uri.parse("https://kiit.ac.in/tour/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }
        //Virtual Button Finish

        binding.viewallbtn.setOnClickListener{
            val uri = Uri.parse("https://kiit.ac.in/events/")

            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }

        // Home Menu Linking
        binding.societiesbtn.setOnClickListener {
            startActivity(Intent(context, SocietiesActivity::class.java))
        }

        binding.academicsbtn.setOnClickListener {
            startActivity(Intent(context, AcademicsActivity::class.java))
        }

        binding.campuslifebtn.setOnClickListener {
            startActivity(Intent(context, CampusLifeActivity::class.java))
        }

        binding.placementsbtn.setOnClickListener {
            startActivity(Intent(context, PlacementActivity::class.java))
        }

        binding.knowfounderbtn.setOnClickListener {
            startActivity(Intent(context, FounderActivity::class.java))
        }

        binding.knowkiitbtn.setOnClickListener {
            startActivity(Intent(context, KnowKiitActivity::class.java))
        }


        return binding.root
    }


}