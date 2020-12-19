package com.example.notekeeper

object DataManager {
    val courses = HashMap<String, CourseInfo>()
    val notes = ArrayList<NoteInfo>()

    init {
        initializeCourses()
        initializeNotes()
    }

    private fun initializeCourses() {
        var course = CourseInfo("android_intents", "Android Programming with Intents")
        courses.set(course.courseId, course)

        course = CourseInfo("android_async", "Android Async Programming and Services")
        courses.set(course.courseId, course)

        course = CourseInfo("java_lang","Java Fundamentals: The Java Language")
        courses.set(course.courseId, course)

        course = CourseInfo("java_core", "Java Fundamentals: The Core Platform")
        courses.set(course.courseId, course)
    }

    private fun initializeNotes() {
        var note = NoteInfo(CourseInfo("android_intents", "Android Programming with Intents"),
                            "Dynamic intent resolution", "Wow, intents allow components to be resolved at runtime")
        notes.add(note)

        note = NoteInfo(CourseInfo("android_intents", "Android Programming with Intents"),
            "Delegating intents", "Pending intents are powerful; they delegate much more than just a component invocation")
        notes.add(note)

        note = NoteInfo(CourseInfo("android_async", "Android Async Programming and Services"),
                            "Service Default Threads", "Did you know that by default an Android Service will tie up the UI thread?")
        notes.add(note)

        note = NoteInfo(CourseInfo("android_async", "Android Async Programming and Services"),
            "Long running operations", "Foreground services can be tied to a notification icon")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals: The Java Language"),
            "Parameters", "Leverage variable-length parameter lists")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_lang", "Java Fundamentals: The Java Language"),
            "Anonymous classes", "Anonymous classes simplify implementing one-use types")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_core", "Java Fundamentals: The Core Platform"),
            "Compiler options", "The -jar option isn't compatible with the -cp option")
        notes.add(note)

        note = NoteInfo(CourseInfo("java_core", "Java Fundamentals: The Core Platform"),
            "Serialization", "Remember to include SerialVersionUID to assure version compatibility")
        notes.add(note)
    }
}