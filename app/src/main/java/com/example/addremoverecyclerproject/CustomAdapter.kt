package com.example.addremoverecyclerproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.addremoverecyclerproject.databinding.ItemMainBinding

class CustomAdapter(val dataList: MutableList<DataVO>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val binding = ItemMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val binding = holder.binding
        binding.tvName.text = dataList.get(position).tvName.toString()
        binding.tvAge.text = dataList.get(position).tvAge.toString()
        binding.tvMail.text = dataList.get(position).tvMail.toString()
        binding.ivPicture.setImageResource(dataList.get(position).ivPicture)
        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${dataList[position].toString()}",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.root.setOnLongClickListener(object : View.OnLongClickListener {
            override fun onLongClick(v: View?): Boolean {
                val position = holder.adapterPosition
                Toast.makeText(
                    binding.root.context,
                    "${dataList[position].tvName} 삭제완료",
                    Toast.LENGTH_SHORT
                ).show()
                val dataVO = dataList.removeAt(position)
                notifyDataSetChanged()
                return true
            }

        })
    }

    class CustomViewHolder(val binding: ItemMainBinding) : RecyclerView.ViewHolder(binding.root)

}