package com.test;

import com.test.model.TestModel;
import com.test.task.PrintStringsTask;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;
import org.gradle.model.Defaults;
import org.gradle.model.Model;
import org.gradle.model.ModelMap;
import org.gradle.model.Mutate;
import org.gradle.model.Path;
import org.gradle.model.RuleSource;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ListTestPlugin implements Plugin<Project> {

  public void apply(Project project) {
    // do any project space related work in here
  }

  public static class PluginRules extends RuleSource {

    @Model
    public void listTest(TestModel model) {
    }

    @Defaults
    public void setDefaults(TestModel model, @Path("buildDir") File buildDir) {
      List<String> x = new ArrayList<>();
      x.add("goose");
      model.setStrings(x);
      model.setTarget(new File(buildDir, "target"));
    }

    @Mutate
    public void createPrintStrings(final ModelMap<Task> tasks, final TestModel model) {

      System.out.println("List<String> type : " + model.getStrings().getClass());
      System.out.println("Instance of serializable? " + (model.getStrings() instanceof Serializable));

      tasks.create("printStrings", PrintStringsTask.class,
          new Action<PrintStringsTask>() {
            @Override
            public void execute(PrintStringsTask task) {
              task.setTestModel(model);
            }
          });
    }
  }
}

