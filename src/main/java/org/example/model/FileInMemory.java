package org.example.model;

import java.io.*;

public class FileInMemory {
    public File file;
    public String number;
    public DataType dataType;

    private FileReader fileReader;
    private final BufferedReader reader;

    public FileInMemory(File file, DataType dataType) {
        this.file = file;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        reader = new BufferedReader(fileReader);
        this.dataType = dataType;
    }

    public String getLine(){
        String line = "";
        try {
            if (dataType == DataType.STRING) {
                line = reader.readLine();
            } else {
                while ((line = reader.readLine()) != null){
                    try{
                        Integer.parseInt(line);
                        number = line;
                        return number;
                    }catch (NumberFormatException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
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
