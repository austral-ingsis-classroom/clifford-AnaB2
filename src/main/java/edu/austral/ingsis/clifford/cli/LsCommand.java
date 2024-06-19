package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.Collections;
import java.util.List;

public class LsCommand implements Command {
  @Override
  public String execute(FileSystem fs, List<String> args) {
    boolean ascending = args.contains("--ord=asc");
    boolean descending = args.contains("--ord=desc");

    List<String> files = fs.ls(false); // Get the list in the original creation order

    if (ascending) {
      Collections.sort(files); // Sort in ascending order
    } else if (descending) {
      Collections.sort(files, Collections.reverseOrder()); // Sort in descending order
    }

    return String.join(" ", files);
  }
}
