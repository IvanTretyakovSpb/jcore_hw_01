package hm01.view;

import java.util.Scanner;

/**
 * Класс, обеспечивающий в рамках модели MVC взаимодействие с пользователями приложения
 *
 * @author Ivan Tretyakov
 * @version 1.0 14.03.2024
 */
public class UserInterface {
    public static final String menu = """
            =========================================================
                         Приложение "Ведение заметок!"
            =========================================================
               Главное меню:
            ---------------------------------------------------------
            1. Создать новую заметку.
            2. Показать список всех заметок.
            3. Закрыть приложение.
            ---------------------------------------------------------
            """;

    /**
     * Запрашивает у пользователя номер действия из меню приложения
     *
     * @return порядковый номер команды меню
     */
    public int select() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите действие: ");
        int result = scanner.nextInt();
        while (!(result == 1 || result == 2 || result == 3)) {
            System.out.print("Некорректный ввод!\nВыберите действие согласно меню: ");
            result = scanner.nextInt();
        }
        return result;
    }

    /**
     * Запрашивает адрес расположения и название файла для записи заметок или чтения
     *
     * @return строка с адресом файла для дальнейшей работы
     */
    public String askFileAddress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес расположения и название файла для заметок:");
        String fileAddress = scanner.nextLine();
        return fileAddress;
    }

    /**
     * Запрашивает и получает текст заметки для записи в файл
     *
     * @return текст заметки, созданной пользователем
     */
    public String getNote() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст заметки в одну строку:");
        String text = scanner.nextLine();
        return text;
    }
}
