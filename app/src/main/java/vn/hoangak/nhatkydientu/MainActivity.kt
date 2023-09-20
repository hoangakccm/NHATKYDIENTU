package vn.hoangak.nhatkydientu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.TextView
import java.time.Clock
import java.util.Calendar
import java.util.TimeZone


class MainActivity : BaseActivity() {
    private lateinit var nhatkyBtn : Button
    private lateinit var baocaoBtn : Button
    private lateinit var tinnhanBtn : Button
    private lateinit var caidatBtn : Button
    private lateinit var chuyendiTv : TextView
    private lateinit var meCaTv : TextView
    private lateinit var timeView : TextView
    private lateinit var gpsView : TextView
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        initHandleView()

    }


    private fun initHandleView() {
        nhatkyBtn.setOnClickListener {openActivity(DiaryActivity()) }
        baocaoBtn.setOnClickListener {openActivity(LoginActivity()) }
        tinnhanBtn.setOnClickListener {openActivity(LoginActivity()) }

    }

    open fun openActivity(activity: Activity) {
        // Tạo Intent với lớp activity mà bạn muốn chuyển đến
        val intent = Intent(this, activity::class.java)

        // Khởi chạy activity mới
        startActivity(intent)
    }

    private fun initView() {
        nhatkyBtn = findViewById(R.id.nhatkyBtn)
        baocaoBtn = findViewById(R.id.baocaoBtn)
        tinnhanBtn = findViewById(R.id.tinnhanBtn)
        caidatBtn = findViewById(R.id.caidatBtn)
        timeView = findViewById(R.id.timeView)
        gpsView = findViewById(R.id.GPS_id)

    }


}