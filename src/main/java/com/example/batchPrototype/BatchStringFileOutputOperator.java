package com.example.batchPrototype;

import org.apache.apex.malhar.lib.fs.GenericFileOutputOperator.StringFileOutputOperator;

public class BatchStringFileOutputOperator extends StringFileOutputOperator
{
  @Override
  public void teardown()
  {
    try {
      for (String fileName: getFileNameToTmpName().keySet()) {
        finalizeFile(fileName);
      }
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
    super.teardown();
  }
}
