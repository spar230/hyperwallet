This is a Maven project and requires JDK 7 and Maven to compile and run. 

To build the jars:
1) cd to "tasks-rest-api" directory and run "mvn clean install"
2) cd to "tasks-rest-impl" directory and run "mvn clean install"
3) cd to "tasks-rest-controller" directory and "run mvn clean install"
4) cd to "tasks-rest-server" directory and run "mvn clean install"

To run:
cd to "tasks-rest-server" directory and run "java -jar .\target\tasks-rest-server-1.0-SNAPSHOT.jar"

After server starts, go to "http://localhost:8080/api-docs/default/tasks-service-controller" to see the API documentation.

Use something like "Advanced Rest Client" plugin for chrome to test the TasksService.



I have not written any test for the controller but If i had time to I will do something similar to http://spring.io/guides/tutorials/bookmarks/#_testing_a_rest_service

I don't commit the target directory (with classes and build artifacts) into GIT but in this case i did as you might just want to run it without building it.

I have left the default spring validation error message, If i had time i will updated to give a more simpler and user friendly error message.
