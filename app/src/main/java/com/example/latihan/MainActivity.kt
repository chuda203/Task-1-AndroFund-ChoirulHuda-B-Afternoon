package com.example.latihan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import com.example.latihan.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var tv: TextView
    private lateinit var fragmentContainer: FragmentContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tv = binding.textView2
        fragmentContainer = binding.fragmentContainerView

        val username = intent.getParcelableExtra<User>("User")?.username
        val password = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $username dan Password: $password"

        val btnImplicit: Button = binding.btnImplicit
        btnImplicit.setOnClickListener(this)

        binding.btnFragment1.setOnClickListener { replaceFragment(Fragment_1()) }
        binding.btnFragment2.setOnClickListener { replaceFragment(Fragment_2()) }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(fragmentContainer.id, fragment)
        fragmentTransaction.commit()
    }

    override fun onClick(v: View?) {
        when (v?.id){
            R.id.btn_implicit -> {

                val intent = Intent()
                intent.putExtra("history", "Anda sudah login")
                setResult(RESULT_OK,intent)
                finish()

            }
        }
    }
}
