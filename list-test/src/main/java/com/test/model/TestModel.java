package com.test.model;

import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.OutputDirectory;
import org.gradle.model.Managed;

import java.io.File;
import java.util.List;

@Managed
public interface TestModel {

  @OutputDirectory
  File getTarget();
  void setTarget(File target);

  @Input
  List<String> getStrings();
  void setStrings(List<String> strings);
}
