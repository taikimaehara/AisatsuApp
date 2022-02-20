package jp.techacademy.taiki.maehara.aisatsuapp

import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Log.d("UI_PARTS", "ボタンをタップしました")
            showTimePickerDialog()
        }
    }

    private fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { view, hour, minute ->
                    Log.d("UI_PARTS", "$hour:$minute")
                    aisatsu(hour)
                },
                0, 0, true)
        timePickerDialog.show()
    }

    private fun aisatsu(hour: Int){
        if(hour >= 2 && hour < 10) {
            text.setText("おはよう")
        } else if(hour >= 10 && hour < 18) {
            text.setText("こんにちは")
        } else if((hour >= 18 && hour < 24) || (hour >= 0 && hour < 2)) {
            text.setText("こんばんは")
        } else {
            text.setText("不正")
        }
    }

}