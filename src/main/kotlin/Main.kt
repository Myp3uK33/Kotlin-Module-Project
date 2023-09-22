fun main() {
    val archives = mutableListOf<Archive>()
    val menuHelper = MenuHelper(listOf("Выбор архива", "Создание архива", "Выбор заметки", "Создание заметки", "Экран заметки"))

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
                    if (archiveIndex in archives.indices) {
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
                val archiveName = readLine() ?: ""
                if (archiveName.isNotEmpty()) {
                    archives.add(Archive(archiveName))
                    println("Архив успешно создан")
                } else {
                    println("Название архива не может быть пустым")
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
                        archive.addNote()
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
                    if (archiveIndex in archives.indices) {
                        val archive = archives[archiveIndex]
                        archive.showNotes()
                        println("Выберите заметку:")
                        val noteIndex = menuHelper.readInput() - 1
                        if (noteIndex in archive.notes.indices) {
                            println("Текст заметки: ${archive.notes[noteIndex]}")
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
            else -> {
                println("Выход из программы")
                return
            }
        }
    }
}