package edu.austral.ingsis.clifford;

import java.util.*;

public class FileSystemImpl implements FileSystem {
  private final Directory root;
  private Directory current;

  public FileSystemImpl() {
    root = new Directory("");
    current = root;
  }

  @Override
  public void mkdir(String name) {
    Directory newDir = new Directory(name);
    current.add(newDir);
  }

  @Override
  public void touch(String name) {
    File newFile = new File(name);
    current.add(newFile);
  }

  @Override
  public void cd(String path) {
    if (path.equals("..")) {
      current = root; // Go to root
      if (current.getParent() != null) {
        current = current.getParent();
      }
    } else if (path.equals(".")) {
    } else {
      String parts[] = path.split("/");

      Directory newCurrent = current;
      for (int i = 0; i < parts.length; i++) {
        String part = parts[i];
        FileSystemElement newElement = newCurrent.getSubDirectory(part);
        if (newElement instanceof Directory) {
          newCurrent = (Directory) newElement;
        } else {
          throw new IllegalArgumentException("Directory does not exist");
        }
      }
      current = newCurrent;
    }
  }

  //
  //    } else
  //
  //
  //
  //      if(path.startsWith("/")) {
  //      // Absolute path
  //      current = root;  // Start from root
  //      String[] directories = path.substring(1).split("/");
  //      for (String dir : directories) {
  //        if (!dir.isEmpty()) {  // Skip the first empty string before the first "/"
  //          FileSystemElement newCurrentElement = current.getSubDirectory(dir);
  //          if (newCurrentElement instanceof Directory) {
  //            current = (Directory) newCurrentElement;
  //          } else {
  //            throw new IllegalArgumentException("Directory does not exist");
  //          }
  //        }
  //      }
  //    }
  //  else  {
  //      // Relative path
  //      FileSystemElement newCurrentElement = current.getSubDirectory(path);
  //      if (newCurrentElement instanceof Directory) {
  //        current = (Directory) newCurrentElement;
  //      } else {
  //        throw new IllegalArgumentException("Directory does not exist");
  //      }
  //    }
  //  }

  @Override
  public void rm(String name, boolean recursive) {
    FileSystemElement element = current.getSubDirectory(name);
    if (element == null) {
      throw new IllegalArgumentException("File or directory does not exist");
    }
    if (element instanceof Directory && !recursive) {
      throw new IllegalArgumentException("Cannot remove directory without --recursive option");
    }
    current.remove(name, recursive);
  }

  @Override
  public List<String> ls(boolean ascending) {
    List<String> names = new ArrayList<>(current.list());
    if (ascending) {
      Collections.sort(names);
    }
    return names;
  }

  @Override
  public String pwd() {

    return current.getPath();
  }
}
