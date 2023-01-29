package org.example.command.implement;

import org.example.Compare;
import org.example.command.MergeSort;
import org.example.model.DataType;
import org.example.model.TypeSort;
import org.example.command.Command;
import org.example.model.FileInMemory;
import java.util.ArrayList;
import java.util.List;

public class Sort implements Command {
    private final List<FileInMemory> map = new ArrayList<>();
    private final TypeSort typeSort;
    private final DataType dataType;

    public Sort(DataType dataType, TypeSort typeSort){
        this.typeSort = typeSort;
        this.dataType = dataType;
    }

    @Override
    public <T> void execute(List<FileInMemory> files) {
        String fileOut = files.get(0).file.getPath();
        List<T> list = new ArrayList<>();
        MergeSort sort = new MergeSort(typeSort, dataType);

        for (int i = 1; i < files.size(); i++){
            String line = files.get(i).getLine();
            if (line != null) {
                if (line.contains(" ") || line.length() == 0) {
                    System.out.println("The file is damaged");
                    return;
                }
                list.add((T) line);
                map.add(files.get(i));
            } else {
                System.out.println("File " + files.get(i).file.getName() + " contains string datatype");
            }
        }
        if (list.size() == 0){
            System.out.println("Files do not contain numbers");
            return;
        }
        sort.mergeSort(list);
        T previosMinItem = list.get(0);
        boolean fileIsDamage = false;

        while (true) {
            T minNum = list.get(0);
            FileInMemory file = map.stream()
                    .filter(x -> x.number.equals(String.valueOf(minNum)))
                    .findFirst()
                    .get();

            if (Compare.compare(previosMinItem, minNum, dataType, typeSort)) {
                System.out.println("The file " + file.file.getName() + " is damaged");
                fileIsDamage = true;
            } else {
                previosMinItem = list.get(0);
            }

            if (!fileIsDamage) {
                file.writeToFile(fileOut);
            }
            String line = file.getLine();

            if (line == null) {
                List<T> listTemp = list;
                list = new ArrayList<>(list.size() - 1);
                for (int i = 1; i < listTemp.size(); i++) {
                    list.add(listTemp.get(i));
                }
                map.remove(file);
            } else {
                if (line.contains(" ") || line.length() == 0) {
                    System.out.println("The file is damaged");
                    return;
                }
                list.set(0, (T) line);
            }

            if (list.size() == 0) {
                return;
            }
            sort.mergeSort(list);
            fileIsDamage = false;
        }
    }
}
