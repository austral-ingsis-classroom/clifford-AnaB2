package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory {
  private final String name;
  private final List<Directory> subDirectories;
  private final List<File> files;
  private Directory parent;

  public Directory(String name) {
    this.name = name;
    this.subDirectories = new ArrayList<>();
    this.files = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void add(Directory dir) {
    dir.setParent(this);
    subDirectories.add(dir);
  }

  public void add(File file) {
    files.add(file);
  }

  public Directory getSubDirectory(String name) {
    for (Directory dir : subDirectories) {
      if (dir.getName().equals(name)) {
        return dir;
      }
    }
    return null;
  }

  public void remove(String name, boolean recursive) {
    for(Iterator<File> it = files.iterator(); it.hasNext();){
      File file = it.next();
      if(file.getName().equals(name)){
        it.remove();
        return;
      }
    }

    for(Iterator<Directory> it = subDirectories.iterator(); it.hasNext();){
      Directory dir = it.next();
      if(dir.getName().equals(name)) {
        if (recursive) {
          it.remove();
        } else {
          throw new IllegalArgumentException("Directory is not empty");
        }
        return;
      }
    }

    throw new IllegalArgumentException("File or directory does not exist");
  }

  public List<String> list() {
    List<String> names = new ArrayList<>();
    for (Directory dir : subDirectories) {
      names.add(dir.getName());
    }
    for (File file : files) {
      names.add(file.getName());
    }
    return names;
  }

  public String getPath() {
    if (parent == null) {
      return name;
    } else {
      return parent.getPath() + "/" + name;
    }
  }

  public void setParent(Directory parent) {
    this.parent = parent;
  }

  public Directory getParent() {
    return parent;
  }
}