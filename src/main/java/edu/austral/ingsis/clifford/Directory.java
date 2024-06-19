package edu.austral.ingsis.clifford;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {
  private final String name;
  private final List<FileSystemElement> elements;
  private Directory parent;

  public Directory(String name) {
    this.name = name;
    this.elements = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public void add(FileSystemElement element) {
    element.setParent(this);
    elements.add(element);
  }

  public FileSystemElement getSubDirectory(String name) {
    for (FileSystemElement element : elements) {
      if (element.getName().equals(name)) {
        return element;
      }
      if (element instanceof Directory) {
        FileSystemElement subElement = ((Directory) element).getSubDirectory(name);
        if (subElement != null) {
          return subElement;
        }
      }
    }
    return null;
  }

  public void remove(String name, boolean recursive) {
    FileSystemElement element = getSubDirectory(name);
    if (element instanceof File) {
      elements.remove(element);
    }

    if (element instanceof Directory) {
      Directory directory = (Directory) element;
      if (!directory.elements.isEmpty() && !recursive) {
        throw new IllegalArgumentException("Directory is not empty");
      } else if (!directory.elements.isEmpty()) {
        for (FileSystemElement e : new ArrayList<>(directory.elements)) {
          if (e instanceof Directory) {
            directory.remove(e.getName(), true);
          } else {
            directory.elements.remove(e);
          }
        }
      }
    }
    elements.removeIf(e -> e.getName().equals(name));
  }

  public List<String> list() {
    List<String> names = new ArrayList<>();
    for (FileSystemElement element : elements) {
      names.add(element.getName());
    }
    return names;
  }

  @Override
  public String getPath() {
    if (parent == null) {
      return name;
    } else {
      return parent.getPath() + "/" + name;
    }
  }

  @Override
  public void setParent(Directory parent) {
    this.parent = parent;
  }

  public Directory getParent() {
    return parent;
  }
}
