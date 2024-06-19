package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class MkdirCommand implements Command {
  @Override
  public String execute(FileSystem fs, List<String> args) {
    if (args.isEmpty()) {
      throw new IllegalArgumentException("Directory name is required");
    }

    String dirName = args.get(0);
    fs.mkdir(dirName);
    return "'" + dirName + "' directory created";
  }
}
