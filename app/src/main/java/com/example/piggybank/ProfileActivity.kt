package com.example.piggybank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_profile.*

lateinit var historyPagerAdapter: ProfileActivity.HistoryPagerAdapter

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val accountModel = intent.getSerializableExtra("account") as? AccountModel
        textViewBalance.text = "₹" + accountModel?.getBalance().toString()
        textViewDeposited.text = "₹" + accountModel?.getDeposit().toString()
        textViewWithdrawal.text = "₹" + accountModel?.getWithdraw().toString()

        historyPagerAdapter = HistoryPagerAdapter(supportFragmentManager)
        val depositHistoryFragment = DepositHistoryFragment()
        val withdrawHistoryFragment = WithdrawHistoryFragment()

        tabLayout.setupWithViewPager(viewPagerHistory)
        historyPagerAdapter.addFragment(depositHistoryFragment)
        historyPagerAdapter.addFragment(withdrawHistoryFragment)

        viewPagerHistory.adapter = historyPagerAdapter


    }

    inner class HistoryPagerAdapter(fm: FragmentManager?) :
        FragmentPagerAdapter(fm!!, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragmentList: ArrayList<Fragment> = ArrayList()
        private val title = arrayOf<String>("Deposits", "Withdraws")

        override fun getItem(i: Int): Fragment {
            return fragmentList[i]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment) {
            fragmentList.add(fragment)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return title[position]
        }
    }

}