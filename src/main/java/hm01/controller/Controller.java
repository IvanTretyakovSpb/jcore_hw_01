package hm01.controller;

import hm01.view.UserInterface;
import hm01.model.WriterNotes;

import java.time.LocalDate;

/**
 * Класс Контроллер для взаимодействия в рамках реализации модели MVC
 *
 *  * @author Ivan Tretyakov
 *  * @version 1.0 14.03.2024
 */
public class Controller {
    private final UserInterface userInterface;
    private final WriterNotes writerNotes;

    /**
     * Конструктор по умолчанию, но с инициализацией приватных констант
     */
    public Controller() {
        this.userInterface = new UserInterface();
        this.writerNotes = new WriterNotes();
    }

    /**
     * Запускает работу приложения с заметками.
     * Отображает в консоли меню приложения и распределяет работу команд приложения.
     */
    public void start() {
        while (true) {
            System.out.println(UserInterface.menu);
            int select = userInterface.select();
            switch (select) {
                case 1 -> createNote();
                case 2 -> printNotes();
                case 3 -> {
                    System.out.println("\nПриложение \"Ведение заметок!\" закрыто!");
                    return;
                }
            }
        }
    }

    /**
     * Создаёт новую заметку и записывает её в указанный файл
     */
    public void createNote() {
        String fileAddress = userInterface.askFileAddress();
        String textNote = userInterface.getNote();
        LocalDate date = LocalDate.now();
        String note = String.format("\n%s -> %s", date, textNote);
        writerNotes.write(note, fileAddress);
        System.out.println("Дозапись в файл: " + note);
    }

    /**
     * Вывод в консоль текста всех заметок в файле построчно
     */
    public void printNotes() {
        String fileAddress = userInterface.askFileAddress();
        writerNotes.read(fileAddress);
    }
}
