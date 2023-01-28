package org.example.model;

import java.io.*;

public class FileInMemory {
    public File file;
    public String number;

    private FileReader fileReader;
    private final BufferedReader reader;

    public FileInMemory(File file) {
        this.file = file;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        reader = new BufferedReader(fileReader);
    }

    public String getLine(){
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println("File not found");
        }
        number = line;

        return number;
    }

    public void writeToFile(String fileOut) {
        try (final FileWriter writer = new FileWriter(fileOut, true)) {
            writer.write(number + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
