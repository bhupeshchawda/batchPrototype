/**
 * Put your copyright and license info here.
 */
package com.example.batchPrototype;

import org.apache.hadoop.conf.Configuration;

import com.datatorrent.api.annotation.ApplicationAnnotation;
import com.datatorrent.contrib.formatter.CsvFormatter;
import com.datatorrent.contrib.parser.CsvParser;
import com.datatorrent.api.StreamingApplication;
import com.datatorrent.api.Context;
import com.datatorrent.api.DAG;

@ApplicationAnnotation(name="BatchApplication")
public class Application implements StreamingApplication
{

  @Override
  public void populateDAG(DAG dag, Configuration conf)
  {
    BatchLineFileInputOperator input = dag.addOperator("BatchInput", BatchLineFileInputOperator.class);
    input.setDirectory("/tmp/input");

    String schema = "{\"separator\": \";\",\n    \"quoteChar\":\"\\\"\",\n    \"fields\": [\n        {\n            \"name\": \"msidn\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"imsi\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"imei\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"plan\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"call_type\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"corresp_type\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"corresp_isdn\",\n            \"type\": \"String\"\n        },\n        {\n            \"name\": \"duration\",\n            \"type\": \"long\"\n        },\n        {\n            \"name\": \"time\",\n            \"type\": \"String\"},\n        {\n            \"name\": \"date\",\n            \"type\": \"String\"\n        }    ]\n}";
    CsvParser parser = dag.addOperator("Parser", CsvParser.class);
    parser.setSchema(schema);
    dag.setOutputPortAttribute(parser.out, Context.PortContext.TUPLE_CLASS, POJO.class);

    CsvFormatter formatter = dag.addOperator("Formatter", CsvFormatter.class);
    formatter.setSchema(schema);
    dag.setInputPortAttribute(formatter.in, Context.PortContext.TUPLE_CLASS, POJO.class);

    BatchStringFileOutputOperator output = dag.addOperator("Output", new BatchStringFileOutputOperator());
    output.setFilePath("/tmp/output");
    output.setOutputFileName("data");
//    output.setAlwaysWriteToTmp(false);

    dag.addStream("stream1", input.output, parser.in);
    dag.addStream("stream2", parser.out, formatter.in);
    dag.addStream("stream3", formatter.out, output.input);
  }
}
