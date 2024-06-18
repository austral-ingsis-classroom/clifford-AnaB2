package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class TouchCommand implements Command{
  @Override
  public String execute(FileSystem fs, List<String> args) {
    if (args.isEmpty()) {
      throw new IllegalArgumentException("File name is required");
    }

    String filename = args.get(0);
    fs.touch(filename);
    return "'" + filename + "' file created";

  }
}
