/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.test.task;

import com.test.model.TestModel;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Nested;
import org.gradle.api.tasks.TaskAction;

public class PrintStringsTask extends DefaultTask {
  private TestModel testModel;

  @Nested
  public TestModel getTestModel() {
    return testModel;
  }

  public void setTestModel(TestModel testModel) {
    this.testModel = testModel;
  }

  @TaskAction
  void printTestStrings() throws Exception {
    for (String x : testModel.getStrings()) {
      System.out.print(x);
    }
  }
}