package vn.hoangak.nhatkydientu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : BaseActivity() {
    private lateinit var exitBtn : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initView()
        initHandleView()
    }

    fun openActivity(activity: Activity) {
        // Tạo Intent với lớp activity mà bạn muốn chuyển đến
        val intent = Intent(this, activity::class.java)

        // Khởi chạy activity mới
        startActivity(intent)
    }
    private fun initHandleView() {
        exitBtn.setOnClickListener { openActivity(MainActivity()) }
    }

    private fun initView() {
        exitBtn = findViewById(R.id.exitBtn)
    }
}