SET MAVEN_OPTS=-Xdebug -Xnoagent -Djava.compiler=NONE -Dcom.sun.management.jmxremote -Xmx384m -Xms128m -Xrunjdwp:transport=dt_socket,address=2222,server=y,suspend=n
mvn jetty:run