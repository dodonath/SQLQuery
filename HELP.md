# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Lombok installation guide](https://www.baeldung.com/lombok-ide)
* [Maven installation guide](https://www.javatpoint.com/how-to-install-maven)

### Guides
The following steps illustrate how to run the features concretely:

* Download the lombok and install in the IDE
* Download maven and set it up
* Download this springboot project
* run -> maven clean install
* run the spring boot application 
* Once the server is started use the followig link [Swagger link](http://localhost:8080/swagger-ui.html) to check the API details
* Click on the [link](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/sql-controller) to run the API.
* The sample json files and their corresponding ouput sqls are stored in the resources folder of the project

### Comments
* The json files are stored in the resources folder
* The structure of the json are mapped to ParseDTO .The structure can be viewed either in the swagger under the schema section or the DTO in the code
* The topics covered are conditions,orderby,subquery and joins
* Only natural joins are supported as of now . Future iteration will have INNER,OUTER,LEFT,RIGHT joins
* GroupBys and its related features are not suppoerted in this iteration

