package com.example.addremoverecyclerproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addremoverecyclerproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var dataList: MutableList<DataVO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataList = mutableListOf<DataVO>()
        for (i in 1..30) {
            if (i % 2 == 0) {
                dataList.add(DataVO("홍길동${i}", "${20 + i}세", "rlawn${i}@gmail.com", R.drawable.man))
            } else {
                dataList.add(
                    DataVO(
                        "홍길여${i}",
                        "${20 + i}세",
                        "rlawn${i}@gmail.com",
                        R.drawable.womam
                    )
                )
            }
        }
        binding.recyclerView.adapter = CustomAdapter(dataList)
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        binding.recyclerView.setHasFixedSize(true)
        binding.btnFAB.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnFAB -> {
                val dialog = CustomDialog(this, binding)
                dialog.showDialog()
            }
        }
    }

    fun refreshRecyclerView(dataVO: DataVO) {
        dataList.add(dataVO)
        binding.recyclerView.adapter?.notifyDataSetChanged()
        Toast.makeText(applicationContext, "${dataVO.tvName} 추가되었습니다.", Toast.LENGTH_SHORT).show()
    }
}