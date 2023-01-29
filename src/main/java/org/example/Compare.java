package org.example;

import org.example.model.DataType;
import org.example.model.TypeSort;

public final class Compare {
    public static <T> boolean compare(T i1, T i2, DataType dataType, TypeSort typeSort){
        boolean result = false;
        switch (typeSort){
            case ASCENDING -> {
                switch (dataType){
                    case INTEGER ->
                            result = Integer.parseInt(String.valueOf(i1)) > Integer.parseInt(String.valueOf(i2));

                    case STRING ->
                            result = String.valueOf(i1).compareTo(String.valueOf(i2)) > 0;
                }
            }
            case DESCENDING -> {
                switch (dataType){
                    case INTEGER ->
                            result = Integer.parseInt(String.valueOf(i1)) < Integer.parseInt(String.valueOf(i2));
                    case STRING ->
                            result = String.valueOf(i1).compareTo(String.valueOf(i2)) < 0;
                }
            }
        }
        return result;
    }
}
