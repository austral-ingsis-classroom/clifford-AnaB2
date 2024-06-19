package edu.austral.ingsis.clifford;

public class File implements FileSystemElement {
  private final String name;
  private Directory parent;

  public File(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
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

  @Override
  public Directory getParent() {
    return parent;
  }
}