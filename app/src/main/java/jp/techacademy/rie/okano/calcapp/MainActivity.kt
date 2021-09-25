package jp.techacademy.rie.okano.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.util.Log
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (editText.text.toString() == "" || editText2.text.toString() == "") {
            if (v != null) {
                Snackbar.make(v, "２つの数字を入力してボタンを押してください", Snackbar.LENGTH_INDEFINITE)
                    .setAction("OK"){
                        Log.d("UI_PARTS", "数字の未入力があります")
                    }.show()
            }
        }else {
            val num1 =  editText.text.toString().toFloat()
            val num2 =  editText2.text.toString().toFloat()
            var ans = 0.0F
                if (v != null) {
                    when (v.id) {
                        R.id.button -> {
                            ans = num1 + num2
                        }
                        R.id.button2 -> {
                            ans = num1 - num2
                        }
                        R.id.button3 -> {
                            ans = num1 / num2
                        }
                        R.id.button4 -> {
                            ans = num1 * num2
                        }
                        else -> {
                            //
                        }
                    }
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("VALUE1", ans)
                    startActivity(intent)
                }
            }
        }
    }



