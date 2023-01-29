package org.example;

import org.example.command.Command;
import org.example.command.implement.Sort;
import org.example.model.DataType;
import org.example.model.FileInMemory;
import org.example.model.TypeSort;

import javax.naming.PartialResultException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final List<FileInMemory> files = new ArrayList<>();
    private static TypeSort parameter = TypeSort.ASCENDING;
    private static DataType dataType;
    private static String fileOut;

    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args){
        int len;
        try {
            len = getParameters(args);
            if ((len + 1) == args.length){
                System.err.println("Specify input files");
                return;
            }
        } catch (FileNotFoundException | NoSuchElementException e) {
            System.out.println(e.getMessage());
            return;
        }
        File file = new File(fileOut);
        if (file.exists()){
            file.delete();
        }
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.err.println("Wrong data");
            return;
        }

        if (!setFiles(args, len)) return;

        Command c = new Sort(dataType, parameter);
        c.execute(files);
    }

    private static boolean setFiles(String[] command, int len){
        for (int i = len; i < command.length; i++){
            File file = new File(command[i]);
            if (file.exists()){
                FileInMemory fileInMemory = new FileInMemory(file, dataType);
                files.add(fileInMemory);
            }
            else{
                System.err.println("File " + command[i] + " not found!");
                return false;
            }
        }

        return true;
    }

    private static int getParameters(String[] args) throws FileNotFoundException, NoSuchElementException {
        int len = 0;
        var arr = Arrays.asList(args);
        if (arr.contains("-d")){
            parameter = TypeSort.DESCENDING;
            len++;
        } else if (arr.contains("-a")){
            parameter = TypeSort.ASCENDING;
            len++;
        }

        if (arr.contains("-i")){
            dataType = DataType.INTEGER;
            len++;
        } else if (arr.contains("-s")){
            dataType = DataType.STRING;
            len++;
        } else {
            throw new NoSuchElementException("Enter the data type!");
        }

        Optional<String> file = arr.stream()
                .filter(x -> x.endsWith(".txt"))
                .findFirst();

        if (file.isEmpty()){
            throw new FileNotFoundException("Enter the out file");
        }

        fileOut = file.get();
        return len;
    }
}