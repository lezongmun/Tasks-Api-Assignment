# Tasks API Assignment

## Prerequisites
Before you begin, ensure that you have met the following requirements:
- You have installed Java 17 or above.
- You have installed Maven.

## Installation
- Clone the project repository to your local machine
- Open the project in your IDE
- Navigate to the project directory
- Build the project using the following command:    
``` 
mvn clean install
 ```
- Start the Spring Boot application using the following command:    
 ```
 java -jar target/tasks-api-0.0.1-SNAPSHOT.jar
 ```

- Use Postman or a web browser to call the endpoints through `localhost:8080`


## Usage

### Endpoints
The following endpoints are provided:
- `GET /tasks`: Returns a list of all tasks.
- `POST /tasks`: Creates a new task.
- `GET /tasks/{id}`: Returns a single task by ID.
- `PUT /tasks/{id}`: Updates a task by ID.
- `DELETE /tasks/{id}`: Deletes a task by ID.

<br>
<br>

#### GET/tasks

    No parameters required  
##### Example:    
    localhost:8080/tasks

<br>
<br>

#### POST /tasks
##### Query Parameters:
`Long id`: unique ID of the task    
`String title`: Title of the task   
`String description`: Description of the task   
`Boolean completed`: Indication of whether the task has been completed  
##### Example:
```
localhost:8080/tasks?id=4&title=sampleTitle&description=sampleDescription&completed=false
```

<br>
<br>

#### GET /tasks/{id}
##### Path Parameters:
`Long id`: unique ID of the task
##### Example:
```
localhost:8080/tasks/1
```

<br>
<br>

#### PUT /tasks/{id}
##### Path Parameters:
`Long id`: unique ID of the task    
##### Query Parameters:
`String title` (optional): Title of the task    
`String description` (optional): Description of the task     
`Boolean completed` (optional): Indication of whether the task has been completed  
##### Example:
```
localhost:8080/tasks/3?title=changedTitle&completed=true
```

<br>
<br>

#### DELETE /tasks/{id}
##### Path Parameters:
`Long id`: unique ID of the task    
##### Example:
```
localhost:8080/tasks/1
```