package com.example.notekeeper

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.content_note_list.*

class NoteListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            val activityIntent = Intent(this, MainActivity::class.java)
            startActivity(activityIntent)
        }

        // Populate the list
        listNotes.adapter = ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                DataManager.notes)

        // Allow selection of a note to bring up the edit note screen
        listNotes.setOnItemClickListener { parent, view, position, id ->
            // Create the Intent
            val activityIntent = Intent(this, MainActivity::class.java)
            // Include the position of the selected note
            activityIntent.putExtra(EXTRA_NOTE_POSITION, position)
            // start activity
            startActivity(activityIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        // Ensure the list is updated when we return to this activity
        (listNotes.adapter as ArrayAdapter<NoteInfo>).notifyDataSetChanged()
    }
}