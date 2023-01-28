package org.example.command;

import org.example.model.DataType;
import org.example.model.TypeSort;
import org.example.model.FileInMemory;
import java.util.List;

public interface Command {
    <T> void execute(List<FileInMemory> file);
}