package edu.student.week8

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val txtshow = findViewById<TextView>(R.id.txtShow)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val txtsend = findViewById<EditText>(R.id.txtSend2)

        //loads intent string from MainActivity.kt

        var strShow: String = intent.getStringExtra("SendStuff")
        txtshow.text = strShow

        val btngo = findViewById<Button>(R.id.btnpg3)

        btngo.setOnClickListener(View.OnClickListener {
            //Intent is used to send data between activities
            val intent = Intent(this, Main3Activity::class.java)
            //putExtra sets value to name SendStuff (Could be called whatever you want
            intent.putExtra("SendStuff",txtsend.text.toString())
            //Go to second activity
            startActivity(intent)

        })

        btnBack.setOnClickListener(View.OnClickListener {
            this.finish()
        })

        //Fire hidekeyboard when user taps outside any text object
//Place below code right before last right bracket in function onCreate
        findViewById<View>(android.R.id.content).setOnTouchListener { _, event ->
            hideKeyboard()
            false
        }

    }

    //function to hide keyboard goes right before the last right bracket of Class MainActivity
//should auto import android.content.Context
//should auto add import android.view.inputmethod.InputMethodManager
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}