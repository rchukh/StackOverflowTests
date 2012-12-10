## Setup

You need to prepare local jboss instance before running tests.

1. Download JBoss (Tested on 7.1.1)
2. Copy mysql-connector-java-5.1.21.jar to %JBOSS_HOME%/modules/com/mysql/main
3. Create a 'module.xml' file in the same folder with following content:

```xml
    <?xml version="1.0" encoding="UTF-8"?>
    <module xmlns="urn:jboss:module:1.0" name="com.mysql">
      <resources>
        <resource-root path="mysql-connector-java-5.1.21.jar"/>
      </resources>
      <dependencies>
        <module name="javax.api"/>
      </dependencies>
    </module>
```

4. Add com.mysql driver into <drivers> section of %JBOSS_HOME%/standalone/configuration/standalone.xml

```xml
    <drivers>
        <driver name="com.mysql" module="com.mysql"/>
    ...
    </drivers>
```

5. Start Standalone JBoss

```
    %JBOSS_HOME%/bin/standalone.sh
```

6. Run test

```
    mvn clean test -Parq-jbossas-remote
```