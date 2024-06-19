package edu.austral.ingsis.clifford.cli;

import edu.austral.ingsis.clifford.FileSystem;
import java.util.List;

public class PwdCommand implements Command {
  @Override
  public String execute(FileSystem fs, List<String> args) {
    return fs.pwd();
  }
}
