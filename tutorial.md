Demo Steps
==========

### Setting up Love Match
- Checkout Love Match Sample.
```
git clone https://github.com/michaelsuzukisagi/lovematch.git
```
- Run Love Match
```
cd into lovematch
./run.sh
```
- Verify all running and that there are 4 users.
```
http://localhost:8080/alfresco/service/sample/lovematch
```
### Setting Alfresco benchmark
- Start mongodb.
- Create a new benchmark directory.
- Checkout the Benchmark server into the new benchmark directory.
```
git clone https://github.com/AlfrescoBenchmark/alfresco-benchmark.git
cd alfresco-benchmark/server
```
- Start the Benchmark Server
```
mvn tomcat7:run -Dmongo.config.host=127.0.0.1
```
- View the dashboard page
```
localhost:9080/alfresco-benchmark-server/
```
### Adding the love match driver
- Create a directory called drivers.
- Checkout love match driver to drivers directory
```
https://github.com/michaelsuzukisagi/lovematch-driver.git
```
- Start the love match driver
```
mvn tomcat7:run -Dmongo.config.host=127.0.0.1
```
- Check the driver is loaded by creating test and see in the Test Definition dropdown that it appears.

### Adding the benchmark drivers

- Checkout User signup driver to drivers directory.
```
svn co https://svn.alfresco.com/repos/alfresco-open-mirror/benchmark/tests/ent-signup/trunk/ signup
cd signup
```
- Start the user signup driver
```
mvn tomcat7:run -Dmongo.config.host=127.0.0.1
```
- Check the driver is loaded by creating test and see in the Test Definition dropdown that it appears.
