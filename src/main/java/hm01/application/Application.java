package hm01.application;

import hm01.controller.Controller;

/**
 * Главный класс для запуска приложения для внесения заметок во внешний файл
 *
 * @author Ivan Tretyakov
 * @version 1.0 14.03.2024
 */
public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.start();
    }
}
