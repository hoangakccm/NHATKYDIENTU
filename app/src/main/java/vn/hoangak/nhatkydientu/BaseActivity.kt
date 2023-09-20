package vn.hoangak.nhatkydientu

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.TimeZone

open class BaseActivity : AppCompatActivity() {
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupToolbar()
    }

    private fun setupToolbar() {
        val timeView = findViewById<TextView>(R.id.timeView)
        if (timeView != null) {
            updateTimeRunnable(timeView)

        }
    }
        private fun updateTimeRunnable(textView: TextView) {
        val updateTimeRunnable = object : Runnable {
            override fun run() {
                showTime(textView)
                //showTime(timeView)
                handler.postDelayed(this, 1000) // Cập nhật mỗi giây
            }
        }
        // Bắt đầu cập nhật thời gian
        handler.post(updateTimeRunnable)
    }
    fun showTime(textView: TextView) {
        // Lấy thời gian hiện tại từ hệ thống
        val cal = Calendar.getInstance()

        // Chuyển đổi thời gian sang múi giờ của Việt Nam
        val timeZone = TimeZone.getTimeZone("Asia/Ho_Chi_Minh")
        cal.timeZone = timeZone

        // Lấy giờ hiện tại theo định dạng hh:mm:ss
        val time = String.format("%02d:%02d:%02d",
            cal.get(Calendar.HOUR_OF_DAY),
            cal.get(Calendar.MINUTE),
            cal.get(Calendar.SECOND))
        // Lấy thứ hiện tại
        val dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)
        val dayOfWeekString = when (dayOfWeek) {
            Calendar.MONDAY -> "Thứ Hai"
            Calendar.TUESDAY -> "Thứ Ba"
            Calendar.WEDNESDAY -> "Thứ Tư"
            Calendar.THURSDAY -> "Thứ Năm"
            Calendar.FRIDAY -> "Thứ Sáu"
            Calendar.SATURDAY -> "Thứ Bảy"
            Calendar.SUNDAY -> "Chủ Nhật"
            else -> {}
        }
        // Lấy ngày hiện tại
        val day = cal.get(Calendar.DAY_OF_MONTH)
        // Lấy tháng hiện tại
        val month = cal.get(Calendar.MONTH) + 1
        val year = cal.get(Calendar.YEAR)
        // Hiển thị thời gian lên TextView
        textView.text = time + " Thứ $dayOfWeek, $day/$month/$year"
    }
    override fun onDestroy() {
        super.onDestroy()
        // Loại bỏ callbacks để ngăn vòng lặp
        handler.removeCallbacksAndMessages(null)
    }
}
