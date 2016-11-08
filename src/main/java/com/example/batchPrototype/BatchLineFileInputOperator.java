package com.example.batchPrototype;

import org.apache.apex.malhar.lib.fs.LineByLineFileInputOperator;

import com.datatorrent.api.DefaultOutputPort;

public class BatchLineFileInputOperator extends LineByLineFileInputOperator
{
  private boolean shutDown = false;

  public final transient DefaultOutputPort<byte[]> output = new DefaultOutputPort<>();

  @Override
  public void beginWindow(long windowId)
  {
    super.beginWindow(windowId);
    if (shutDown) {
      throw new ShutdownException();
    }
  }

  @Override
  protected void emit(String tuple)
  {
    output.emit(tuple.getBytes());
  }
  @Override
  public void endWindow()
  {
    super.endWindow();

    if ((currentFile == null || offset < 0) && pendingFiles.isEmpty() && unfinishedFiles.isEmpty() && failedFiles.isEmpty()) {
      shutDown = true;
    }
  }
}
