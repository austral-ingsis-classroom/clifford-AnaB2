package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class CdCommand implements Command{
  @Override
  public String execute(FileSystem fs, List<String> args) {
    if(args.isEmpty()){
      throw new IllegalArgumentException("Directory name is required");
    }
    String dir = args.get(0);
    fs.cd(dir);
    return "moved to directory '" + dir + "'";
  }
}