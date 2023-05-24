package com.example.registration

class Validator {
    fun validateName(Name : String, Case : Boolean = false) : Boolean{
        if (Name.isEmpty()){
            return false
        }
        val loweredName = Name.lowercase()

        if (Case) {
            var space = false
            for (i in loweredName) {
                if (i == ' ') {
                    if (!space) {
                        space = true
                    } else {
                        return false
                    }
                } else if (i > 'z' || i < 'a') {
                    return false
                }
            }
            return space
        }

        else{
            for (i in loweredName) {
                if (i > 'z' || i < 'a') {
                    return false
                }
            }
            return true
        }
    }

    fun validateEmail(email : String) : Boolean{

        if (email.isEmpty()){
            return false
        }

        return (('@' in email) &&
                ('.' in email) &&
                (validateName((email.slice(email.indexOf('@')+1 until email.indexOf('.'))).toString())) &&
                (validateName((email.slice(email.indexOf('.')+1 until email.length).toString()))))

    }

    fun validatePass(pass : String) : Boolean{
        if (pass.isEmpty()){
            return false
        }
        var sym = false
        var num = false
        for (i in pass){
            if (!sym && (i in "!@#$%^&*")){
                sym = true
            }
            if (!num && (i >= '0' || i <= '9')){
                num = true
            }
        }
        return ( (pass.length >= 8) && (!validateName(pass)) && (sym) && (num))
    }

    fun validateAge(age : Int) : Boolean {
        return (age >= 13 && age <= 100)
    }

}