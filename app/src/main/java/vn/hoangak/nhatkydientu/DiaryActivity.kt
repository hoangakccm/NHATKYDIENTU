package vn.hoangak.nhatkydientu

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class DiaryActivity : BaseActivity() {

    private lateinit var exitBtn: Button
    private lateinit var xuatbenIv: ImageView
    private lateinit var thaluoiIv: ImageView
    private lateinit var thuluoiIv: ImageView
    private lateinit var nhapnhatkyIv: ImageView
    private lateinit var nhapbenIv: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diary)
        initView()
        initHandleView()
    }

    private fun initView() {
        exitBtn = findViewById(R.id.exitBtn)
        xuatbenIv = findViewById(R.id.xuatbenIv)
        thaluoiIv = findViewById(R.id.thaluoiIv)
        thuluoiIv = findViewById(R.id.thuluoiIv)
        nhapnhatkyIv = findViewById(R.id.nhapnhatkyIv)
        nhapbenIv = findViewById(R.id.nhapbenIv)

        // Set default state for the first time launch
        updateImageViewAuto(xuatbenIv, R.drawable.xuatben_on, getImageViewState("xuatbenIv", true))
        updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, getImageViewState("thuluoiIv", false))
        updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on, getImageViewState("thaluoiIv", false))
        updateImageViewAuto(nhapnhatkyIv, R.drawable.nhapnhatky_on, getImageViewState("nhapnhatkyIv", false))
        updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on, getImageViewState("nhapbenIv", false))
    }

    private fun initHandleView() {
        exitBtn.setOnClickListener { openActivity(MainActivity()) }

        xuatbenIv.setOnClickListener {
            updateImageViewAuto(xuatbenIv, R.drawable.xuatben_on, false)
            updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, false)
            updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on, true)
            updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on, true)
        }
        thaluoiIv.setOnClickListener {
            updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, true)
            updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on, false)
            updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on, false)
        }

        thuluoiIv.setOnClickListener {
            updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on,false)
            updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on,false)
            updateImageViewAuto(nhapnhatkyIv, R.drawable.nhapnhatky_on, true)
        }

        nhapbenIv.setOnClickListener {
            updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, false)
            updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on,false)
            updateImageViewAuto(nhapnhatkyIv, R.drawable.nhapnhatky_on,false)
            updateImageViewAuto(xuatbenIv, R.drawable.xuatben_on, true)
            updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on,false)
        }

        nhapnhatkyIv.setOnClickListener {
            updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, false)
            updateImageViewAuto(nhapnhatkyIv, R.drawable.nhapnhatky_on,false)
            updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on, true)
            updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on, true)
            openActivity(FishYieldActivity())
        }
    }

    fun openActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
    }

    fun updateImageViewAuto(imageView: ImageView, baseResId: Int, enabled: Boolean) {
        val resource = if (enabled) baseResId else baseResId - 1
        imageView.setImageResource(resource)
        imageView.isEnabled = enabled
    }

    fun saveImageViewState(imageView: ImageView, key: String) {
        val sharedPreferences = getSharedPreferences("DiaryActivityPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean(key, imageView.isEnabled)
        editor.apply()
    }

    fun getImageViewState(key: String, defaultValue: Boolean): Boolean {
        val sharedPreferences = getSharedPreferences("DiaryActivityPrefs", MODE_PRIVATE)
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    override fun onPause() {
        super.onPause()
        saveImageViewState(xuatbenIv, "xuatbenIv")
        saveImageViewState(thuluoiIv, "thuluoiIv")
        saveImageViewState(thaluoiIv, "thaluoiIv")
        saveImageViewState(nhapnhatkyIv, "nhapnhatkyIv")
        saveImageViewState(nhapbenIv, "nhapbenIv")
    }

    override fun onResume() {
        super.onResume()
        updateImageViewAuto(xuatbenIv, R.drawable.xuatben_on, getImageViewState("xuatbenIv", true))
        updateImageViewAuto(thuluoiIv, R.drawable.thuluoi_on, getImageViewState("thuluoiIv", false))
        updateImageViewAuto(thaluoiIv, R.drawable.thaluoi_on, getImageViewState("thaluoiIv", false))
        updateImageViewAuto(nhapnhatkyIv, R.drawable.nhapnhatky_on, getImageViewState("nhapnhatkyIv", false))
        updateImageViewAuto(nhapbenIv, R.drawable.nhapben_on, getImageViewState("nhapbenIv", false))
    }
}
