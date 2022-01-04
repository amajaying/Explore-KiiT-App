package com.example.kiitappver2.fragments
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.kiitappver2.LoginActivity
import com.example.kiitappver2.R
import com.google.firebase.auth.FirebaseAuth
import com.example.kiitappver2.databinding.FragmentHome2Binding
import com.google.firebase.database.DataSnapshot

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentHome2Binding? = null

    private val binding get() = _binding!!


    private lateinit var firebaseAuth: FirebaseAuth

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
        /* Inflate the layout for this fragment */
        _binding = FragmentHome2Binding.inflate(inflater, container, false)

        //
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()


        val imageSlider = binding.imageSlier
        val imageList = ArrayList<SlideModel>()


        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_four.png?alt=media&token=4bcf1fb3-717f-4d77-b902-c57ab24798b8"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_one.png?alt=media&token=3431cc5f-eece-45e0-9619-63c45eefc024"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_three.png?alt=media&token=b913792e-af40-46ba-bd11-cd7844bf48d4"))
        imageList.add(SlideModel("https://firebasestorage.googleapis.com/v0/b/appfinalkiit.appspot.com/o/SliderImages%2Fslider_two.png?alt=media&token=7e26353d-ab40-425b-a988-b6c9353445ac"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)




        return binding.root
    }

    fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null){
            startActivity(Intent(context, LoginActivity::class.java))
        }
        else{


        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}