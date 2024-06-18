package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class RmCommand implements  Command{
  @Override
  public String execute(FileSystem fs, List<String> args) {
    if(args.isEmpty()){
      throw new IllegalArgumentException("File or directory name is required");
    }
    String name= args.get(0);
    boolean recursive = args.contains("--recursive");
    fs.rm(name, recursive);
    return "'" + name + "' removed";


  }
}
