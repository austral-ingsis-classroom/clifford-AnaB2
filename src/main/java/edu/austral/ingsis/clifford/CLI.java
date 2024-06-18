package edu.austral.ingsis.clifford;

import edu.austral.ingsis.clifford.cli.Command;
import java.util.List;
import java.util.Scanner;

public class CLI {
  private final FileSystem fs;
  private final CommandFactory commandFactory;


  public CLI(FileSystem fs, CommandFactory commandFactory) {
    this.fs = fs;
    this.commandFactory = commandFactory;
  }


  public void run(){
    Scanner scanner = new Scanner(System.in);
    while (true){
      System.out.print("$ ");
      String line = scanner.nextLine();
      String[] parts = line.split(" ");
      String commandName = parts[0];
      List<String> args = List.of(parts).subList(1,parts.length);
      Command command = commandFactory.createCommand(commandName);
      String result = command.execute(fs,args);
      System.out.println(result);


    }


  }




}
