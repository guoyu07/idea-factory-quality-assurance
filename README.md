idea-factory-quality-assurance
==============================

The lecture about Quality Assurance for Idea Factory

Running code coverage
------------------------------

Compile everything:

```bash
mvn compile
```

Run Server using Java 7:

```bash
$ java -javaagent:org.jacoco.agent-0.7.1.201405082137-runtime.jar=destfile=jacoco-it.exec -cp "rmi-server/target/classes;rmi-server/target/lib/*;rmi-client/target/classes;rmi-client/target/lib/*;" pl.edu.knbit.qa.server.Server
```

Run all tests:

```bash
mvn install
```

Exit Server and generate jacoco-it.exec.

Run:

```bash
$ sonar-runner
```

Alternative way
------------------------------

```bash
mvn sonar:sonar
```
