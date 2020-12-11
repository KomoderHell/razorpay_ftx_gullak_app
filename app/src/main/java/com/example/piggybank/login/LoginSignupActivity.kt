package com.example.piggybank.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.piggybank.R
import kotlinx.android.synthetic.main.activity_login_signup.*

lateinit var authenticationPagerAdapter: LoginSignupActivity.AuthenticationPagerAdapter

class LoginSignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_signup)
        val loginFragment: LoginFragment =
            LoginFragment()
        val registerFragment: RegisterFragment =
            RegisterFragment()
        authenticationPagerAdapter = AuthenticationPagerAdapter(supportFragmentManager)
        authenticationPagerAdapter.addFragment(loginFragment)
        authenticationPagerAdapter.addFragment(registerFragment)
        viewPager.adapter =
            authenticationPagerAdapter

    }

    inner class AuthenticationPagerAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!! , FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragmentList: ArrayList<Fragment> = ArrayList()
        override fun getItem(i: Int): Fragment {
            return fragmentList[i]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment( fragment: Fragment) {
            fragmentList.add(fragment)
        }
    }
}