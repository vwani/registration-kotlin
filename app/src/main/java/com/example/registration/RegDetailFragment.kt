package com.example.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.registration.databinding.FragmentRegDetailBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class RegDetailFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentRegDetailBinding
    var user =  Users("", "", "", 0, "", "")

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvfName.text = "Name: " + user.name
        binding.tvfEmail.text = "Email: " + user.email
        binding.tvfAge.text = "Age: " + user.age
        binding.tvfGender.text = "Gender: " + user.gender
        binding.tvfYear.text = "Year: " + user.year
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegDetailBinding.inflate(layoutInflater, container, false)
        user = arguments?.getSerializable("user") as Users
        return (binding.root)
    }

    companion object {
        fun newInstance(user: Users): RegDetailFragment {
            val fragment = RegDetailFragment()
            val args = Bundle()
            args.putSerializable("user", user)
            fragment.arguments = args
            return fragment
        }
    }

}