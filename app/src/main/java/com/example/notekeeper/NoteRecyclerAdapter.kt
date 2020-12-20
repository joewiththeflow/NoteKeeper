package com.example.notekeeper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteRecyclerAdapter(private val context: Context, private val notes: List<NoteInfo>) :
    RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    // Marking this class as inner allows the class to access the context of its containing class
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Create the properties to be able to access textViews when we bind later
        val textCourse = itemView.findViewById<TextView?>(R.id.textCourse)
        val textTitle = itemView.findViewById<TextView?>(R.id.textTitle)

        // Create a property to be able to track the position of the note which is currently in the viewHolder
        var notePosition = 0

        // Use an init block to set a clickListener for the entire itemView
        // Use it to create an intent, pass the note position and start MainActivity
        init {
            itemView.setOnClickListener {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(NOTE_POSITION, notePosition)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Use the layout inflater to inflate the view (i.e. the card cell layout)
        // parent - refers to the ViewGroup that is passed in
        // we let the adapter deal with attaching the card to the parent so pass false
        val itemView = layoutInflater.inflate(R.layout.item_note_list, parent, false)

        // return an instance of our inner class ViewHolder, passing in this inflated card
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the note at the position
        val note = notes[position]

        // Set the text for the text views (holder is our passed in ViewHolder class)
        holder.textCourse?.text = note.course?.title
        holder.textTitle?.text = note.title

        // Use the position which is passed in to set the notePosition variable in the ViewHolder
        holder.notePosition = position
    }

    override fun getItemCount() = notes.size

}