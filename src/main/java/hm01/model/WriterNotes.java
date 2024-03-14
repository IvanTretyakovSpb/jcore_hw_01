package hm01.model;

import java.io.*;

/**
 * Класс, обеспечивающий взаимодействие с внешним файлом с заметками.
 * Осуществляющий запись заметок и их чтение из файла.
 *
 * @author IvanTretyakov
 * @version 1.0 14.03.2024
 */
public class WriterNotes {

    /**
     * Записывает в указанный файл текст новой заметки с текущей датой создания.
     *
     * @param note текст заметки для записи
     * @param fileName адрес файла для записи в него заметки
     */
    public void write(String note, String fileName) {
        File file = new File(fileName);
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(note);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Выводит на печать информацию о всех заметках, содержащихся в файле
     *
     * @param fileName адрес расположения и имя файла для чтения заметок.
     */
    public void read(String fileName) {
        File file = new File(fileName);
        try (FileReader fr = new FileReader(file); BufferedReader reader = new BufferedReader(fr)) {
            String line = reader.readLine();
            if (line == null) {
                System.out.println("В файле отсутствуют заметки!");
                return;
            }
            System.out.println("В файле содержатся следующие заметки:");
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}