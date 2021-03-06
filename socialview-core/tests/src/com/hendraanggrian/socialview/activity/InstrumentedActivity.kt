package com.hendraanggrian.socialview.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.widget.ProgressBar
import com.hendraanggrian.socialview.test.R
import com.hendraanggrian.widget.SocialEditText

/**
 * @author Hendra Anggrian (hendraanggrian@gmail.com)
 */
open class InstrumentedActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar
    lateinit var editText: SocialEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instrumented)
        setSupportActionBar(findViewById<Toolbar>(R.id.toolbar))
        progressBar = findViewById(R.id.progressBar)
        editText = findViewById(R.id.editText)
    }
}