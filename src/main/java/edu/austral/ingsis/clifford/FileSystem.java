package edu.austral.ingsis.clifford;

import java.util.List;

public interface FileSystem {

  void mkdir(String name);
  void touch(String name);
  void cd(String path);
  void rm(String name, boolean recursive);
  List<String> ls(boolean ascending);
  String pwd();









}
