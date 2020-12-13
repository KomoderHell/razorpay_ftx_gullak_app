package com.example.piggybank

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.card_account.view.*

internal class AccountAdapter(
    private var accounts: ArrayList<AccountModel>,
    private var context: Context
) :
    RecyclerView.Adapter<AccountAdapter.AccountViewHolder>() {
    internal inner class AccountViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_account, parent, false)
        return AccountViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return accounts.size
    }

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        val account = accounts[position]
        holder.itemView.textViewSerialNo.text = account.id.toString() + "."
        holder.itemView.accountTitle.text = account.title
        val bal = account.getBalance()
        holder.itemView.netBalance.text = account.getBalance().toString()
        if (bal >= account.threshold) {
            holder.itemView.netBalance.setTextColor(Color.parseColor("#00FF00"))
        } else {
            holder.itemView.netBalance.setTextColor(Color.parseColor("#FFFF00"))
        }
        val with = (account.getBalance() - account.threshold)
        if (with <= 0) {
            holder.itemView.withdrawable.text = "0"
            holder.itemView.withdrawable.setTextColor(Color.parseColor("#FF0000"))
        } else {
            holder.itemView.withdrawable.text = with.toString()
            holder.itemView.withdrawable.setTextColor(Color.parseColor("#00FF00"))
        }

        holder.itemView.textViewDetails.setOnClickListener {
            val intent = Intent(context, ProfileActivity::class.java)
            intent.putExtra("account",account)
            context.startActivity(intent)
        }
    }
}