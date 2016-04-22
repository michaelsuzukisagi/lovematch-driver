Love Match Benchmark Driver
===========================
Load tests the sample Alfresco WebScript with the Alfresco Benchmark framework.

* <a href="https://www.youtube.com/watch?v=_8w5TxjBgh4&list=PLktNOqTikHe8wXFvWnV8s7TbTlV4K2flf">Videos from Alfresco Summit 2014</a> showing the test being used in AWS.
* The <a href="https://github.com/AlfrescoBenchmark/alfresco-benchmark">Alfresco Benchmark Framework Project</a> required to execute load tests.
* The <a href="https://wiki.alfresco.com/wiki/Benchmark_Testing_with_Alfresco">Benchmark Testing with Alfresco Wiki page</a> has links to the artifacts and source code for all related products.
* The <a href="https://wiki.alfresco.com/wiki/Benchmark_Framework_2.0">Architecture and setup</a> of the tests 

This project produces a WAR file that acts as a headless load driver application designed to run in Tomcat7.  It is used in conjunction with the <a href="https://github.com/AlfrescoBenchmark/alfresco-benchmark">Alfresco Benchmark Framework</a> application, which is a separate application containing a browser-based client that configures and controls test execution.

* Follow instructions for the <a href="https://wiki.alfresco.com/wiki/Benchmark_Framework_2.0#Benchmark_Server_Setup">Benchmark Server set up</a>.
* Ensure that Love Match is running before starting <a href="https://github.com/michaelsuzukisagi/lovematch"> Love Match Sample</a>
### The Love Match Driver
The purpose of the love match driver is to fire a get request to the love match API and record the response time.
This driver was created as part of the Demo that demonstrates how to benchmark an Alfresco add on.
### Running The Love Match Driver
```
mvn tomcat7:run -Dmongo.config.host=127.0.0.1
```

