package com.example.fragmentapplicaion

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController



// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var etEmailaddress: EditText
    private lateinit var etpassword:EditText
    private lateinit var etforget:TextView
    private lateinit var btnlogin: Button
    private lateinit var tvcreate:TextView
    private lateinit var initView : View

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
        initView =  inflater.inflate(R.layout.fragment_login, container, false)
        return initView;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etEmailaddress=initView.findViewById(R.id.etEmailAddress)
        etpassword=initView.findViewById(R.id.etPassword)
        etforget=initView.findViewById(R.id.tvforget)
        tvcreate=initView.findViewById(R.id.tvcreate)
        tvcreate.setOnClickListener {
            findNavController().navigate(R.id.registrationFragment)
        }
        etforget.setOnClickListener {
            findNavController().navigate(R.id.forgetFragment,null)
        }
        btnlogin=initView.findViewById(R.id.btnlogin)
        btnlogin.setOnClickListener {
           var enteredetEmailaddress= etEmailaddress.text.toString()
            var enteredetpassword=etpassword.text.toString()
            if (TextUtils.isEmpty(enteredetEmailaddress) || !enteredetEmailaddress.contains("@")){
                    etEmailaddress.error=("EMAIL IS INVALID")
                    return@setOnClickListener
                }
                else if (TextUtils.isEmpty(enteredetpassword) || enteredetpassword.length<6){
                    etpassword.error=("PASSWORD MUST BE MORE THAN 6 DIGITS")
                    return@setOnClickListener
                }
            else{
                findNavController().navigate(R.id.screenFragment, null)
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
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}