package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class RmCommand implements Command {
  @Override
  public String execute(FileSystem fs, List<String> args) {
    if(args.isEmpty()){
      throw new IllegalArgumentException("File or directory name is required");
    }

    if(args.size() == 1) {
      String name = args.get(0);
      try {
        fs.rm(name, false);
        return "'" + name + "' removed";
      }catch (IllegalArgumentException e) {
        return String.format("cannot remove '%s', is a directory", name);
      }
    }


    String name = args.get(1);
    boolean recursive = args.contains("--recursive");
    try {
      fs.rm(name, recursive);
      return "'" + name + "' removed";
    } catch (IllegalArgumentException e) {
      return e.getMessage();
    }
  }
}