Demo Steps
==========

### Setting up Love Match Add-on
- Checkout Love Match Sample.
```
git clone https://github.com/michaelsuzukisagi/lovematch.git
```
- Run Love Match
```
cd into lovematch
./run.sh
```
- Verify love match add-on is running and that there are 4 users.
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
- Check the driver is loaded by creating a new test. See in the Test Definition dropdown that it appears.
### Running the Love Match driver
- Create a new load test LoveMatch.
- Update the mongodb location.
```
mongo.test.host=127.0.0.1:27017
```
- Create a new test run with title run1 and description:Love Match load test with 4 users.
- Run the test.
- Once test completed download the results.
- Copy test and update title to run2 and description Love Match load test with 1000 users.

### Adding the signup driver

- Checkout User signup driver to drivers directory.
```
svn co https://svn.alfresco.com/repos/alfresco-open-mirror/benchmark/tests/ent-signup/trunk/ signup
cd signup
```
- Start the user signup driver
```
mvn tomcat7:run -Dmongo.config.host=127.0.0.1
```
- Check the driver is loaded by creating a new test. See in the Test Definition dropdown that it appears.
### Loading 1000 Users
- Create a new signup test.
- Update mongodb location.
```
mongo.test.host=127.0.0.1:27017
```
- Update user last name to smith from test in User Details.
- Update number of users to 10000 in signup load parameters.
- Update signup delay to 5 milliseconds.
- Create a new run to load 10000 users.
- Run test.

### Rerun Love Match Driver against Alfresco
- Navigate to http://localhost:8080/alfresco/service/sample/lovematch to user count is 1004.
- Return to benchmark and run LoveMatch run2 with a count of 400.
