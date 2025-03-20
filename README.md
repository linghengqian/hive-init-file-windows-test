# hive-init-file-windows-test

- For https://github.com/linghengqian/hive-server2-jdbc-driver/pull/28 .
- Execute the following command on the `Windows 11` instance with `PowerShell/PowerShell`, 
  `version-fox/vfox`, `git-for-windows/git` and `rancher-sandbox/rancher-desktop` installed.

```shell
vfox add java
vfox install java@21.0.6-ms
vfox use --global java@21.0.6-ms

git clone git@github.com:linghengqian/hive-init-file-windows-test.git
cd ./hive-init-file-windows-test/
./mvnw clean test -T 1C
```

- The log is as follows,
```shell
D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test git:[master]
./mvnw clean test -T 1C
[INFO] Scanning for projects...
[INFO] 
[INFO] Using the MultiThreadedBuilder implementation with a thread count of 16
[INFO] 
[INFO] ---------< io.github.linghengqian:hive-init-file-windows-test >---------
[INFO] Building hive-init-file-windows-test 1.0-SNAPSHOT
[INFO]   from pom.xml
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- clean:3.2.0:clean (default-clean) @ hive-init-file-windows-test ---
[INFO] Deleting D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\target
[INFO] 
[INFO] --- resources:3.3.1:resources (default-resources) @ hive-init-file-windows-test ---
[INFO] skip non existing resourceDirectory D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\main\resources
[INFO]
[INFO] --- compiler:3.13.0:compile (default-compile) @ hive-init-file-windows-test ---
[INFO] No sources to compile
[INFO]
[INFO] --- resources:3.3.1:testResources (default-testResources) @ hive-init-file-windows-test ---
[INFO] Copying 1 resource from src\test\resources to target\test-classes
[INFO]
[INFO] --- compiler:3.13.0:testCompile (default-testCompile) @ hive-init-file-windows-test ---
[INFO] Recompiling the module because of changed source code.
[INFO] Compiling 1 source file with javac [debug release 21] to target\test-classes
[INFO] 
[INFO] --- surefire:3.2.5:test (default-test) @ hive-init-file-windows-test ---
[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running io.github.linghengqian.SimpleTest
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#noProviders for further details.
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0, Time elapsed: 19.36 s <<< FAILURE! -- in io.github.linghengqian.SimpleTest
[ERROR] io.github.linghengqian.SimpleTest.test -- Time elapsed: 19.28 s <<< FAILURE!
org.opentest4j.AssertionFailedError: Unexpected exception thrown: com.zaxxer.hikari.pool.HikariPool$PoolInitializationException: Failed to initialize pool: Illegal character in path at index 45: hive2://dummyhost:00000/demo_ds_0;initFile=D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\test\resources\test.sql    
        at org.junit.jupiter.api.AssertionFailureBuilder.build(AssertionFailureBuilder.java:152)
        at org.junit.jupiter.api.AssertDoesNotThrow.createAssertionFailedError(AssertDoesNotThrow.java:84)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:53)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:36)
        at org.junit.jupiter.api.Assertions.assertDoesNotThrow(Assertions.java:3199)
        at io.github.linghengqian.SimpleTest.test(SimpleTest.java:49)
        at java.base/java.lang.reflect.Method.invoke(Method.java:580)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
        at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
Caused by: com.zaxxer.hikari.pool.HikariPool$PoolInitializationException: Failed to initialize pool: Illegal character in path at index 45: hive2://dummyhost:00000/demo_ds_0;initFile=D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\test\resources\test.sql
        at com.zaxxer.hikari.pool.HikariPool.throwPoolInitializationException(HikariPool.java:596)
        at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:582)
        at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115)
        at com.zaxxer.hikari.HikariDataSource.<init>(HikariDataSource.java:81)
        at io.github.linghengqian.SimpleTest.lambda$test$1(SimpleTest.java:50)
        at org.junit.jupiter.api.AssertDoesNotThrow.assertDoesNotThrow(AssertDoesNotThrow.java:49)
        ... 6 more
Caused by: java.lang.IllegalArgumentException: Illegal character in path at index 45: hive2://dummyhost:00000/demo_ds_0;initFile=D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\test\resources\test.sql
        at java.base/java.net.URI.create(URI.java:932)
        at org.apache.hive.jdbc.Utils.extractURLComponents(Utils.java:491)
        at org.apache.hive.jdbc.Utils.parseURL(Utils.java:445)
        at org.apache.hive.jdbc.HiveConnection.<init>(HiveConnection.java:296)
        at org.apache.hive.jdbc.HiveConnection.<init>(HiveConnection.java:284)
        at org.apache.hive.jdbc.HiveDriver.connect(HiveDriver.java:94)
        at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:121)
        at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364)
        at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206)
        at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476)
        at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561)
        ... 10 more
Caused by: java.net.URISyntaxException: Illegal character in path at index 45: hive2://dummyhost:00000/demo_ds_0;initFile=D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\test\resources\test.sql
        at java.base/java.net.URI$Parser.fail(URI.java:2995)
        at java.base/java.net.URI$Parser.checkChars(URI.java:3166)
        at java.base/java.net.URI$Parser.parseHierarchical(URI.java:3248)
        at java.base/java.net.URI$Parser.parse(URI.java:3196)
        at java.base/java.net.URI.<init>(URI.java:645)
        at java.base/java.net.URI.create(URI.java:930)
        ... 20 more

[INFO] 
[INFO] Results:
[INFO]
[ERROR] Failures: 
[ERROR]   SimpleTest.test:49 Unexpected exception thrown: com.zaxxer.hikari.pool.HikariPool$PoolInitializationException: Failed to initialize pool: Illegal character in path at index 45: hive2://dummyhost:00000/demo_ds_0;initFile=D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\src\test\resources\test.sql
[INFO]
[ERROR] Tests run: 1, Failures: 1, Errors: 0, Skipped: 0
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  21.893 s (Wall Clock)
[INFO] Finished at: 2025-03-20T22:21:08+08:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:3.2.5:test (default-test) on project hive-init-file-windows-test: There are test failures.
[ERROR]
[ERROR] Please refer to D:\TwinklingLiftWorks\git\public\hive-init-file-windows-test\target\surefire-reports for the individual test results.
[ERROR] Please refer to dump files (if any exist) [date].dump, [date]-jvmRun[N].dump and [date].dumpstream.
[ERROR] -> [Help 1]
[ERROR]
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR]
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```
