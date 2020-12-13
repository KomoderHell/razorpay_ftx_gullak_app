package com.example.piggybank

import java.io.Serializable

class WithdrawModel(
    var id: Int,
    var amount: Int,
    var date: Int
)  : Serializable