package edu.austral.ingsis;

import edu.austral.ingsis.clifford.cli.Command;
import edu.austral.ingsis.clifford.CommandFactory;
import edu.austral.ingsis.clifford.FileSystem;
import edu.austral.ingsis.clifford.FileSystemImpl;
import java.util.ArrayList;
import java.util.List;

public class FileSystemRunnerImpl implements FileSystemRunner{

  private final FileSystem fileSystem;
  private final CommandFactory commandFactory;

  public FileSystemRunnerImpl(){
    this.fileSystem = new FileSystemImpl();
    this.commandFactory = new CommandFactory();

  }
  @Override
  public List<String> executeCommands(List<String> commands) {
    List<String> results = new ArrayList<>();
    for(String commandLine : commands){
      String[] commandParts = commandLine.split(" ");
      String commandName = commandParts[0];
        List<String> args = List.of(commandParts).subList(1,commandParts.length);
        Command command = commandFactory.createCommand(commandName);
        String result = command.execute(fileSystem,args);
        results.add(result);
  }
    return results;}
}
