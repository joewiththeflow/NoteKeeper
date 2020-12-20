package com.example.notekeeper

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.fragment_first.*

class MainActivity : AppCompatActivity() {

    var notePosition = POSITION_NOT_SET

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        notePosition = intent.getIntExtra(EXTRA_NOTE_POSITION, POSITION_NOT_SET)

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
            R.id.action_next -> {
                moveNext()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun moveNext() {
        ++notePosition

        // Call the displayNote method on the fragment
        // Untidy possibly but due to the way I used a starter project which had fragments
        // whereas the pluralsight course had no fragments
        // So I have some of the code in the fragment and access it through the nav_host_fragment
        var fragment = nav_host_fragment.childFragmentManager.fragments[0] as FirstFragment
        fragment.displayNote()

        // Invalidate the menu ensures a call to onPrepareOptionsMenu is scheduled below
        invalidateOptionsMenu()
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if(notePosition >= DataManager.notes.lastIndex) {
            val menuItem = menu?.findItem(R.id.action_next)
            if(menuItem != null) {
                menuItem.icon = getDrawable(R.drawable.ic_block_white_24)
                menuItem.isEnabled = false
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onPause() {
        super.onPause()
        saveNote()
    }

    private fun saveNote() {
        val note = DataManager.notes[notePosition]
        note.title = textNoteTitle.text.toString()
        note.text = textNoteText.text.toString()
        note.course = spinnerCourses.selectedItem as CourseInfo
    }
}