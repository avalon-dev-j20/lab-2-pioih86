package ru.avalon.java.j20.labs.tasks;

import ru.avalon.java.j20.labs.Task;

import java.io.*;
import java.nio.file.Paths;

/**
 * Задание №1
 *
 * <p>Тема: "Потоковый ввод-вывод. Чтение и запись данных
 * в двоичном режиме".
 */
public class Task1 implements Task {
    long time = 0;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run() throws IOException {
        File input = new File("assets/countries.txt");
        File output = new File("assets/countries_binary_mode_output.txt");
        String text = read(input);
        write(output, text);

        /*
         * TODO(Студент): Выполнить задание №1
         *
         * 1. Реализовать метод read.
         *
         *    При чтении файла следует пользоваться типами данных:
         *    InputStream и FileInputStream.
         *
         *    Для сохранениня прочитанных данных следует пользоваться
         *    классом ByteArrayOutputStream.
         *
         * 2. Реализовать метод write.
         *
         *    При реализации метода следует пользоваться типами данных:
         *    OutputStream и FileOutputStream.
         *
         * 3. С использованием отладчика проверить корректность работы программы.
         */

    }

    /**
     * Выполняет чтение указанного файла в двоичном режиме.
     *
     * <p>Весь текст файла возвращается в виде одного
     * экземпляра типа {@link String}.
     *
     * @param file файл
     * @return содержимое файла в виде текста.
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private String read(File file) throws IOException {
        StringBuilder result = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufInStream = new BufferedInputStream(inputStream, 512)) {
            int character = 0;
            while ((character = bufInStream.read()) != -1) {
                result.append((char) character);
            }
        }

        return result.toString();
    }

    /**
     * Выполняет запись текстоых данных в файл в двоичном
     * режиме.
     *
     * @param file файл
     * @param text текст
     * @throws IOException в случае ошибок ввода-вывода.
     */
    private void write(File file, String text) throws IOException {
        try(OutputStream outputStream = new FileOutputStream(file);
            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream()) {
            for (int i = 0; i < text.length(); i++) {
                byteOutStream.write(text.charAt(i));
            }
            byteOutStream.writeTo(outputStream);
        }
    }
}
