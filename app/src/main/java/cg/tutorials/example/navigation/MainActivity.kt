package cg.tutorials.example.navigation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var about: EditText? = null
    var name: EditText? = null
    var number: EditText? = null
    var dateOfBirth: EditText? = null

    var yes: RadioButton? = null
    var no: RadioButton? = null
    var fieldOfStudy: EditText? = null

    var move: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        name = findViewById(R.id.name)
        number = findViewById(R.id.number)
        about = findViewById(R.id.AboutMe)
        dateOfBirth = findViewById(R.id.DateOfBirth)
        move = findViewById(R.id.move)
        yes = findViewById(R.id.yes)
        no = findViewById(R.id.no)
        fieldOfStudy = findViewById(R.id.fieldOfStudy)




        move?.setOnClickListener {


            if (about?.text?.trim()?.toString().isNullOrEmpty()) {
                about?.error = "Enter your details"
            }
            else if (name?.text?.toString()?.trim().isNullOrEmpty()) {
                name?.error = "Enter your name"
            }
            else if ((number?.text?.trim()?.length?:0) <10) {
                number?.error = "Enter Valid Number"
            }
            else if (dateOfBirth?.text?.toString()?.trim().isNullOrEmpty()) {
                dateOfBirth?.error = "Enter your Date of Birth"
            }
else if (fieldOfStudy?.visibility == View.VISIBLE){
    if (fieldOfStudy?.text?.toString()?.trim().isNullOrEmpty()){
        fieldOfStudy?.error ="fill this"
    }
            }

            else {
                Toast.makeText(this, "thanks", Toast.LENGTH_SHORT).show()

                var intent = Intent(this, SecondScreen()::class.java)

                intent.putExtra("About_Me", about?.text?.toString()?.trim())
                intent.putExtra("INPUT_NAME", name?.text?.toString()?.trim())
                intent.putExtra("INPUT_NUMBER", number?.text?.toString()?.trim())
                intent.putExtra("INPUT_DOB", dateOfBirth?.text?.trim()?.toString())

                startActivity(intent)


            }

        }
        yes?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                fieldOfStudy?.visibility = View.VISIBLE
            }
            else{
                fieldOfStudy?.visibility = View.INVISIBLE
            }
        }

    }
}

//