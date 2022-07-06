package com.example.fragmentapplicaion

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegistrationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegistrationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var button: Button
    private lateinit var login: TextView
    private lateinit var initView: View

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
        // Inflate the layout for this fragment
        initView = inflater.inflate(R.layout.fragment_registration, container, false)
        return initView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fullname = initView.findViewById(R.id.etName)
        email = initView.findViewById(R.id.etEmailAddress)
        password = initView.findViewById(R.id.etPassword)
        password.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) < 6) {
                password.requestFocus()
                password.error = ("PASSWORD MUST BE 6 DIGITS")
            }
        }

        cpassword = initView.findViewById(R.id.etconfirmpassword)
        button = initView.findViewById(R.id.btn_register)
        login = initView.findViewById(R.id.login)
        login.setOnClickListener {
            findNavController().navigate(R.id.loginFragment, null)
        }
        button.setOnClickListener {
            var enteredfullname = fullname.text.toString()
            var enteredemail = email.text.toString()
            var enteredpassword = password.text.toString()
            var enteredcpass = cpassword.text.toString()
            if (TextUtils.isEmpty(enteredfullname) || enteredfullname.length < 3) {
                fullname.error = resources.getString(R.string.name_is_empty_or_incorrect)
                return@setOnClickListener
            } else if (!enteredemail.contains("@")) {
                email.error = resources.getString(R.string.email_is_empty_or_invalid)
                return@setOnClickListener
            } else if (enteredpassword.length < 6) {
                password.error = resources.getString(R.string.password_is_empty_or_less_than_6_digits)
                return@setOnClickListener
            } else if (!enteredpassword.equals(enteredcpass)) {
                cpassword.error = resources.getString(R.string.password_does_not_match)

            }
            else{
                findNavController().navigate(R.id.phoneFragment,null)
            }
        }
    }
        companion object {
            /**
             * Use this factory method to create a new instance of
             * this fragment using the provided parameters.
             *
             * @param param1 Parameter 1.
             * @param param2 Parameter 2.
             * @return A new instance of fragment RegistrationFragment.
             */
            // TODO: Rename and change types and number of parameters
            @JvmStatic
            fun newInstance(param1: String, param2: String) =
                RegistrationFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
        }
    }
