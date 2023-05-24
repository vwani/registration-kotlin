package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.registration.databinding.ActivityMainBinding
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        var age = 0
        var year = ""

        var validName = false
        var validEmail = false
        var validPass = false
        var validAge = false
        var yearSelected = false

        val a = Validator()

        binding.spYear.setOnSpinnerItemSelectedListener<String> { oldIndex, oldItem, newIndex, newItem ->
            year = newItem
            yearSelected = true
        }

        binding.btnSubmit.setOnClickListener(){
            var name = binding.etName.text.toString()
            var email = binding.etEmail.text.toString()
            var pass = binding.etPass.text.toString()
            val genderButton = binding.rgGender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(genderButton).text.toString()
            if (binding.etAge.text.toString().isEmpty()){
                age = 0
            }
            else{
                age = binding.etAge.text.toString().toInt()
            }

            validName = a.validateName(name, true)
            validEmail = a.validateEmail(email)
            validPass = a.validatePass(pass)
            validAge = a.validateAge(age)

            if (!validName){
                Toast.makeText(applicationContext, "Enter Valid Name", Toast.LENGTH_SHORT).show()
            }
            else if (!validEmail){
                Toast.makeText(applicationContext, "Enter Valid Email", Toast.LENGTH_SHORT).show()
            }
            else if (!validPass){
                Toast.makeText(applicationContext, "Password must be of 8 characters and should contain a number and a symbol.", Toast.LENGTH_SHORT).show()
            }
            else if (!validAge){
                Toast.makeText(applicationContext, "Enter Valid Age", Toast.LENGTH_SHORT).show()
            }
            else if (!yearSelected){
                Toast.makeText(applicationContext, "Select your year", Toast.LENGTH_SHORT).show()
            }
            else{
                val user = Users(name, email, pass, age, gender, year)
                //Toast.makeText(applicationContext, "Registration Successful", Toast.LENGTH_SHORT).show()
                val fragment = RegDetailFragment.newInstance(user)
                fragment.show(supportFragmentManager, "newUserTag")

            }
        }

    }
}