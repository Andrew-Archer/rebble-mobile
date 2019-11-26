package com.rebble.rusty_libpebble2

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_main.*
import com.rebble.rusty_libpebble2_lib.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        loadRustyLibpebble2() //declared in android/rusty-libpebble2-lib/src/main/java/com/rebble/rusty_libpebble2_lib/rusty.kt

        findViewById<TextView>(R.id.txt).let {
            it?.text =  hello("longRewt - coming from Android Kotlin (not Flutter code)")
        }

        var greeting2 = helloDirect("longRewt Direct - coming from Android Kotlin (not Flutter code)")


        fab.setOnClickListener { view ->
            Snackbar.make(view, greeting2, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}