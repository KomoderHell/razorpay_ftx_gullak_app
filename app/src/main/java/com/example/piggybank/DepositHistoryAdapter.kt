package com.example.piggybank

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_deposit_history.view.*

internal class DepositHistoryAdapter(private var deposits: ArrayList<DepositModel>) :
    RecyclerView.Adapter<DepositHistoryAdapter.DepositViewHolder>() {
    internal inner class DepositViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DepositViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_deposit_history, parent, false)
        return DepositViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return deposits.size
    }

    override fun onBindViewHolder(holder: DepositViewHolder, position: Int) {
        val deposit = deposits[position]
        holder.itemView.textViewDate.text = deposit.date.toString()
        holder.itemView.textViewAmount.text = deposit.amount.toString()
        holder.itemView.textViewAmount.setTextColor(Color.parseColor("#00FF00"))
    }
}