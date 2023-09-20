package vn.hoangak.nhatkydientu

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.File
import java.io.IOException

class FishYieldActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var exitBtn : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fish_yield)
        initView()
        initHandleView()

    }

    private fun initHandleView() {
        val fishList = mutableListOf<Fish>()

        val assetManager = this.assets
        try {
            val inputStream = assetManager.open("danhsachca.csv")

            inputStream.bufferedReader().useLines { lines ->
                lines.forEach { fishList.add(Fish(it)) }
            }

            if (fishList.isNotEmpty()) {
                val adapter = FishAdapter(this, fishList)
                val layoutManager = GridLayoutManager(this, 4)
                recyclerView.layoutManager = layoutManager
                recyclerView.adapter = adapter
            } else {
                // Xử lý trường hợp danh sách trống nếu cần
            }
        } catch (e: IOException) {
            e.printStackTrace()
            // Xử lý lỗi nếu cần
        }
        exitBtn.setOnClickListener { finish() }
    }

    private fun initView() {
        recyclerView = findViewById(R.id.recyclerView_id)
        exitBtn = findViewById(R.id.exitBtn)
    }
    fun openActivity(activity: Activity) {
        // Tạo Intent với lớp activity mà bạn muốn chuyển đến
        val intent = Intent(this, activity::class.java)

        // Khởi chạy activity mới
        startActivity(intent)
    }
}