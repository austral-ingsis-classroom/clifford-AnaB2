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
    try {
      fs.cd(dir);

      if(dir.contains("/")){
        String[] directories = dir.split("/");
        if(directories.length == 0){
          return "moved to directory '/'";
        }
        String lastDir = directories[directories.length -1];
        return "moved to directory '" + lastDir + "'";

      }






      if (dir.equals("..") ) {
        return "moved to directory '/'";
      }
      return "moved to directory '" + dir + "'";
    } catch (IllegalArgumentException e) {
      return "'" + dir + "' directory does not exist";
    }
  }
}