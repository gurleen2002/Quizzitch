package com.example.quizzitch.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.quizzitch.R
import com.example.quizzitch.databinding.ActivityChooseAvatarBinding
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_choose_avatar.*

class ChooseAvatar : Fragment() {

    lateinit var binding: ActivityChooseAvatarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_choose_avatar, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding = ActivityChooseAvatarBinding.inflate(LayoutInflater)
//        setContentView(binding.root)

        Toast.makeText(activity,
            "Please select your favourite avatar and then click on done",
            Toast.LENGTH_LONG).show()

        blackWidow.setOnClickListener { operator(view, "black widow") }
        hawkeye.setOnClickListener { operator(view, "hawkeye") }
        blackPanther.setOnClickListener { operator(view, "black panther") }
        falcon.setOnClickListener { operator(view, "falcon") }
        bucky.setOnClickListener { operator(view, "bucky") }
        captainMarvel.setOnClickListener { operator(view, "captain marvel") }
        scarletWitch.setOnClickListener { operator(view, "scarlet witch") }
        thor.setOnClickListener { operator(view, "thor") }
        thanos.setOnClickListener { operator(view, "thanos") }
        starLord.setOnClickListener { operator(view, "star lord") }
        ironMan.setOnClickListener { operator(view, "iron man") }
        spiderMan.setOnClickListener { operator(view, "spider man") }
        captainAmerica.setOnClickListener { operator(view, "captain america") }
        drStrange.setOnClickListener { operator(view, "dr strange") }
        deadpool.setOnClickListener { operator(view, "deadpool") }
        wolverine.setOnClickListener { operator(view, "wolverine") }
        hulk.setOnClickListener { operator(view, "hulk") }
    }

        fun operator(view: View, name: String) {
            val storageRef = FirebaseStorage.getInstance().reference.child("images/$name.jpeg")
// error!            avatarChoosen(view, storageRef)

        }

        fun avatarChoosen(view: View, name: String){
            done.setOnClickListener() {
            val fragment: Fragment = ProfilePage()
            val bundle = Bundle()
            bundle.putString("avatar", name.toString())
            fragment.arguments = bundle
            val cons: ConstraintLayout = view.findViewById(R.id.avatarR)
            cons.visibility = View.GONE
            val transaction: FragmentTransaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.avatarR, fragment)
            transaction.addToBackStack("pic")
            transaction.commit()

        }
        }

    }


