package com.example.piggybank

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_deposit_history.view.*

internal class WithdrawHistoryAdapter(private var withdraws: ArrayList<WithdrawModel>) :
    RecyclerView.Adapter<WithdrawHistoryAdapter.WithdrawViewHolder>() {
    internal inner class WithdrawViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WithdrawViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_deposit_history, parent, false)
        return WithdrawViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return withdraws.size
    }

    override fun onBindViewHolder(holder: WithdrawViewHolder, position: Int) {
        val withdraw = withdraws[position]
        holder.itemView.textViewDate.text = withdraw.date.toString()
        holder.itemView.textViewAmount.text = withdraw.amount.toString()
        holder.itemView.textViewAmount.setTextColor(Color.parseColor("#FF0000"))
    }
}