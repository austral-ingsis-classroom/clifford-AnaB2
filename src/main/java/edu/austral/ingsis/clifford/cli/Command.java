package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public interface Command {
  String execute(FileSystem fs, List<String> args);
}
