package org.example.command;

import org.example.Compare;
import org.example.model.DataType;
import org.example.model.TypeSort;
import java.util.ArrayList;
import java.util.List;

public class Sort {
    private final DataType dataType;
    private final TypeSort typeSort;

    public Sort(TypeSort typeSort, DataType dataType) {
        this.typeSort = typeSort;
        this.dataType = dataType;
    }

    public <T> void mergeSort(List<T> arr){
        int len = arr.size();
        if (len == 1){
            return;
        }

        int mid = len / 2;
        List<T> left = new ArrayList<>(mid);
        List<T> right = new ArrayList<>(len - mid);

        for (int i = 0; i < mid; i++) {
            left.add(arr.get(i));
        }

        for (int i = mid; i < len; i++) {
            right.add(arr.get(i));
        }

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }

    public <T> void merge(List<T> arr, List<T> left, List<T> right){
        int i = 0;
        int j = 0;
        int leftLen = left.size();
        int rightLen = right.size();
        int tempInd = 0;

        while (i < leftLen && j < rightLen){
            if (Compare.compare(left.get(i), right.get(j), dataType, typeSort)){
                arr.set(tempInd, right.get(j));
                j++;
            } else{
                arr.set(tempInd, left.get(i));
                i++;
            }

            tempInd++;
        }

        for (int t = i; t < leftLen; t++){
            arr.set(tempInd++, left.get(t));
        }

        for (int t = j; t < rightLen; t++){
            arr.set(tempInd++, right.get(t));
        }
    }
}
