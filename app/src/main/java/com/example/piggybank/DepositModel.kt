package com.example.piggybank

import java.io.Serializable

class DepositModel(
    var id: Int,
    var order_id: String,
    var amount: Int,
    var date: Int
) : Serializable