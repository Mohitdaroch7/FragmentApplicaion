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
import androidx.navigation.fragment.findNavController

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private lateinit var etnewpassword: EditText
private lateinit var etconfirmpassword: EditText
private lateinit var btn_done:Button
private lateinit var initView: View
/**
 * A simple [Fragment] subclass.
 * Use the [ForgetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ForgetFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        initView=inflater.inflate(R.layout.fragment_forget, container, false)
        return initView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        etnewpassword= initView.findViewById(R.id.etnewpassword)
        etconfirmpassword= initView.findViewById(R.id.etconfirmpassword)
        btn_done= initView.findViewById(R.id.btn_done)
        btn_done.setOnClickListener {
            var enteredpassword=etnewpassword.text.toString()
            var enteredcpassword=etconfirmpassword.text.toString()
            if (TextUtils.isEmpty(enteredpassword) || enteredpassword.length<6){
                etnewpassword.error=("PASSWORD IS LESS THAN 6")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(enteredcpassword) || !enteredpassword.equals(enteredcpassword)){
                etconfirmpassword.error=("PASSWORD DOES NOT MATCH")
                return@setOnClickListener
            }else{
                findNavController().navigate(R.id.otpFragment,null)
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
         * @return A new instance of fragment ForgetFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ForgetFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}