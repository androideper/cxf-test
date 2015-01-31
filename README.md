cxf-test
========
To create web-app output, use the following command:
mvn clean package assembly:single

Web service is exposed in the following address:
http://<server-address>/<application-context>/services/tests/items

To build, run the tests and automatically deploy into tomcat, use th following command:
mvn clean package assembly:single tomcat:deploy

To execute cucumber tests, use the following command:
mvn clean install -Dacceptance
