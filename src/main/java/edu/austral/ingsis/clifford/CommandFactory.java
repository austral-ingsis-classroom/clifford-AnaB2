package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.cli.CdCommand;
import edu.austral.ingsis.clifford.cli.Command;
import edu.austral.ingsis.clifford.cli.LsCommand;
import edu.austral.ingsis.clifford.cli.MkdirCommand;
import edu.austral.ingsis.clifford.cli.PwdCommand;
import edu.austral.ingsis.clifford.cli.RmCommand;
import edu.austral.ingsis.clifford.cli.TouchCommand;

public class CommandFactory {
  public Command createCommand(String command) {
    switch (command) {
      case "ls":
        return new LsCommand();
      case "cd":
        return new CdCommand();
      case "touch":
        return new TouchCommand();
      case "mkdir":
        return new MkdirCommand();
      case "rm":
        return new RmCommand();

       case "pwd":
        return new PwdCommand();

      default:
        throw new IllegalArgumentException("Command not found");
    }
  }






}
