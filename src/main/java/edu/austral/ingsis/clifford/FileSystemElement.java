package edu.austral.ingsis.clifford;

public interface FileSystemElement {
  String getName();
  String getPath();
  void setParent(Directory parent);

  Directory getParent();

}