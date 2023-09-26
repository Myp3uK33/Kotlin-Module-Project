class Archive(val name: String) {
    val notes = mutableListOf<String>()

    fun addNote() {
        println("Введите текст заметки:")
        val note = readLine() ?: ""
        if (note.isNotEmpty()) {
            notes.add(note)
            println("Заметка успешно добавлена")
        } else {
            println("Заметка не может быть пустой")
        }
    }

    fun showNotes() {
        if (notes.isNotEmpty()) {
            println("Список заметок:")
            for (i in notes.indices) {
                println("${i + 1}. ${notes[i]}")
            }
        } else {
            println("Архив пуст")
        }
    }

    class Note(val text: String)

    fun addNote(text: String) {
        if (text.isNotEmpty()) {
            notes.add(text)
            println("Заметка успешно добавлена")
        } else {
            println("Заметка не может быть пустой")
        }
    }
}