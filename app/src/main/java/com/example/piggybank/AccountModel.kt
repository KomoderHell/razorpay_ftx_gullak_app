package com.example.piggybank

import java.io.Serializable

class AccountModel(
    var id: Int,
    var title: String,
    var threshold: Int,
    var deposits: ArrayList<DepositModel>,
    var withdraws: ArrayList<WithdrawModel>
) : Serializable {
    fun getBalance():Int{
        var sum = 0;
        for (deposit in deposits){
            sum += deposit.amount
        }
        for (withdraw in withdraws){
            sum -= withdraw.amount
        }
        return sum
    }

    fun getDeposit():Int{
        var sum = 0;
        for (deposit in deposits){
            sum += deposit.amount
        }
        return sum
    }

    fun getWithdraw():Int{
        var sum = 0;
        for (withdraw in withdraws){
            sum += withdraw.amount
        }
        return sum
    }

}