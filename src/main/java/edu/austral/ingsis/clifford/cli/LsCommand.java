package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class LsCommand implements Command{


  @Override
  public String execute(FileSystem fs, List<String> args) {
    boolean ascending = args.contains("--ord=asc");
    List<String> files = fs.ls(ascending);
    return String.join(" ", files);
  }
}
