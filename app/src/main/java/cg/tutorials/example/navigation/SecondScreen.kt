package cg.tutorials.example.navigation

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SecondScreen (): AppCompatActivity() {
    var tvAbout :TextView ?=null
    var tvname : TextView?=null
    var tvnumber :TextView?=null
    var tvdob:TextView?=null
//    var tvyes:TextView?= null



    var name = ""
    var number =""
    var dob =""
    var about=""
//    var yes =""

    var Back:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second_screen)
intent?.extras?.let {
    about=it.getString("About_Me")?:""
    name = it.getString("INPUT_NAME")?:""
   number= it.getString("INPUT_NUMBER")?:""
    dob = it.getString("INPUT_DOB")?:""
//    yes = it.getString("YES")?:""

}
        tvAbout = findViewById(R.id.AboutYou)
        tvAbout?.setText(about)

        tvname = findViewById(R.id.inName)
        tvname?.setText(name)

        tvnumber = findViewById(R.id.Num)
        tvnumber?.setText(number)

        tvdob = findViewById(R.id.Dob)
        tvdob?.setText(dob)
//        tvyes = findViewById(R.id.InYes)
//        tvyes?.setText(yes)

        Back = findViewById(R.id.Back)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Back?.setOnClickListener {
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}