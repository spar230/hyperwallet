This is a Maven project and requires JDK 7 and Maven to compile and run. 

To build and run, run the command below for each project: 

To build:
1) cd to "tasks-rest-api" directory and run "mvn clean install"
2) cd to "tasks-rest-impl" drrectory and run "mvn clean install"
3) cd to "tasks-rest-controller" drrectory and "run mvn clean install"
4) cd to "tasks-rest-server" drrectory and run "mvn clean install"

To run:
cd to "tasks-rest-server" directory and run "java -jar .\target\tasks-rest-server-1.0-SNAPSHOT.jar"

After server starts, go to "http://localhost:8080/api-docs/default/tasks-service-controller" to see the API documentation.

Use something like "Advanced Rest Client" plugin for chrome to test the taskes service. 



I have not written any test for the controller but If i have to I will do something similar to http://spring.io/guides/tutorials/bookmarks/#_testing_a_rest_service

I have not written any java doc, I will usually write doc for the Interface and the model(e.g: TasksService interface and the Task model) .
