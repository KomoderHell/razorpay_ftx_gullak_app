package com.example.piggybank

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var accountAdapter: AccountAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Accounts"

        val accounts = getDumyData()

        accountAdapter = AccountAdapter(accounts,this)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerViewHome.layoutManager = layoutManager
        recyclerViewHome.adapter = accountAdapter



    }

    private fun getDumyData(): ArrayList<AccountModel> {
        val depositModel = DepositModel(1,"ww",1000,1200)
        val withdrawModel = WithdrawModel(1,500,1600)
        val deposits :ArrayList<DepositModel> = arrayListOf()
        deposits.add(depositModel)
        deposits.add(depositModel)
        deposits.add(depositModel)
        val withdraws : ArrayList<WithdrawModel> = arrayListOf()
        withdraws.add(withdrawModel)
        withdraws.add(withdrawModel)
        withdraws.add(withdrawModel)
        val accountModel = AccountModel(1,"eye operation",500,deposits,withdraws)
        val accounts :ArrayList<AccountModel> = arrayListOf()
        accounts.add(accountModel)
        accounts.add(accountModel)
        accounts.add(accountModel)

        return accounts

    }
}