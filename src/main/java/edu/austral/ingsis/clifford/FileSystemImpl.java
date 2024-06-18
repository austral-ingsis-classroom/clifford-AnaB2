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
      if (current.getParent() != null) {
        current = current.getParent();
      }
    } else if (!path.equals(".")) {
      Directory newCurrent = current.getSubDirectory(path);
      if (newCurrent != null) {
        current = newCurrent;
      } else {
        throw new IllegalArgumentException("Directory does not exist");
      }
    }
  }

  @Override
  public void rm(String name, boolean recursive) {
    current.remove(name, recursive);
  }

  @Override
  public List<String> ls(boolean ascending) {
    List<String> names = current.list();
    if (ascending) {
      Collections.sort(names);
    } else {
      Collections.sort(names, Collections.reverseOrder());
    }
    return names;
  }

  @Override
  public String pwd() {
    return current.getPath();
  }
}