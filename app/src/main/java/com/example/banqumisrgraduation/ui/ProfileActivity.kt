package com.example.banqumisrgraduation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import com.example.banqumisrgraduation.R
import org.w3c.dom.Text

class ProfileActivity : AppCompatActivity() {
    private var isPasswordShown = false
    private lateinit var usernameTextView: TextView
    private lateinit var emailTextView: TextView
    private lateinit var passwordTextView: TextView
    private lateinit var username: String
    private lateinit var email: String
    private lateinit var password: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        usernameTextView = findViewById(R.id.profile_username_tv)
        emailTextView = findViewById(R.id.profile_email_tv)
        passwordTextView = findViewById(R.id.profile_password_tv)
//        username = intent.getStringExtra("username")!!
//        email = intent.getStringExtra("email")!!
//        password = intent.getStringExtra("password")!!
        username = "John Smith"
        email = "example@yahoo.com"
        password = "12345"

        usernameTextView.text = username
        emailTextView.text = email
        passwordTextView.text = "*".repeat(password.length ?: 0)

        val passwordVisibilityImageButton: ImageButton =
            findViewById(R.id.profile_password_visibility_ib)
        passwordVisibilityImageButton.setOnClickListener {
            if (isPasswordShown) {
                passwordVisibilityImageButton.setImageResource(R.drawable.visibility_off_48)
                passwordTextView.text = "*".repeat(password.length)
            } else {
                passwordVisibilityImageButton.setImageResource(R.drawable.visibility_48)
                passwordTextView.text = password
            }
            isPasswordShown = !isPasswordShown
        }
    }
}