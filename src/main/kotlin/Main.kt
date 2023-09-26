fun main() {
    val archives = mutableListOf<Archive>()
    val menuHelper = MenuHelper(listOf("Выбор архива", "Создание архива", "Создание заметки", "Выбор заметки", "Просмотр заметки", "Выход/Назад"))

    while (true) {
        println("Меню:")
        menuHelper.showMenu()

        when (menuHelper.readInput()) {
            1 -> {
                if (archives.isNotEmpty()) {
                    println("Выберите архив:")
                    for (i in archives.indices) {
                        println("${i + 1}. ${archives[i].name}")
                    }
                    val archiveIndex = menuHelper.readInput() - 1
                    if (archiveIndex in 0 until archives.size) {
                        val archive = archives[archiveIndex]
                        archive.showNotes()
                    } else {
                        println("Некорректный выбор архива")
                    }
                } else {
                    println("Архивы отсутствуют")
                }
            }
            2 -> {
                println("Введите название архива:")
                val archiveName = readLine()?.trim()
                if (archiveName.isNullOrEmpty()) {
                    println("Название архива не может быть пустым")
                } else {
                    archives.add(Archive(archiveName))
                    println("Архив успешно создан")
                }
            }
            3 -> {
                if (archives.isNotEmpty()) {
                    println("Выберите архив:")
                    for (i in archives.indices) {
                        println("${i + 1}. ${archives[i].name}")
                    }
                    val archiveIndex = menuHelper.readInput() - 1
                    if (archiveIndex in archives.indices) {
                        val archive = archives[archiveIndex]
                        println("Введите текст заметки:")
                        val noteText = readLine()?.trim()
                        if (noteText.isNullOrEmpty()) {
                            println("Текст заметки не может быть пустым")
                        } else {
                            archive.addNote(noteText)
                            println("Заметка успешно создана")
                        }
                    } else {
                        println("Некорректный выбор архива")
                    }
                } else {
                    println("Архивы отсутствуют")
                }
            }
            4 -> {
                if (archives.isNotEmpty()) {
                    println("Выберите архив:")
                    for (i in archives.indices) {
                        println("${i + 1}. ${archives[i].name}")
                    }
                    val archiveIndex = menuHelper.readInput() - 1
                    if (archiveIndex in 0 until archives.size) {
                        val archive = archives[archiveIndex]
                        archive.showNotes()
                        println("Выберите заметку:")
                        val noteIndex = menuHelper.readInput() - 1
                        val note = archive.notes.getOrElse(noteIndex) { null }
                        if (note != null) {
                            println("Текст заметки: ${note}")
                        } else {
                            println("Некорректный выбор заметки")
                        }
                    } else {
                        println("Некорректный выбор архива")
                    }
                } else {
                    println("Архивы отсутствуют")
                }
            }
            5 -> {
                if (archives.isNotEmpty()) {
                    println("Выберите архив:")
                    for (i in archives.indices) {
                        println("${i + 1}. ${archives[i].name}")
                    }
                    val archiveIndex = menuHelper.readInput() - 1
                    if (archiveIndex in 0 until archives.size) {
                        val archive = archives[archiveIndex]
                        archive.showNotes()
                        println("Выберите заметку:")
                        val noteIndex = menuHelper.readInput() - 1
                        val note = archive.notes.getOrElse(noteIndex) { null }
                        if (note != null) {
                            println("Текст заметки: ${note}")
                        } else {
                            println("Некорректный выбор заметки")
                        }
                    } else {
                        println("Некорректный выбор архива")
                    }
                } else {
                    println("Архивы отсутствуют")
                }
            }
            6 -> {
                println("Выход из программы")
                return
            }
            else -> {
                println("Некорректный выбор")
            }
        }
    }
}