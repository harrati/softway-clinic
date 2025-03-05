# Diagnosis Service API

## Overview
This project provides a REST API for diagnosing medical pathologies based on a health index. It includes:
- A `DiagnosisController` that handles HTTP requests.
- A `DiagnosisService` that processes the health index and returns a pathology diagnosis.
- Integration and unit tests to validate functionality.

## Technologies Used
- Java
- Spring Boot
- JUnit 5
- Spring Test (MockMvc)

## Project Structure
```
/src/main/java/com/harrati/softwayclinic/
  ├── controller/DiagnosisController.java
  ├── service/DiagnosisService.java
/src/test/java/com/harrati/softwayclinic/
  ├── rest/DiagnosisControllerIntegrationTest.java
  ├── service/DiagnosisServiceTest.java
```

## Setup & Running the Application
### Prerequisites
- JDK 17+
- Maven 3+

### Steps to Run
1. Clone the repository:
   ```sh
   git clone https://github.com/harrati/softway-clinic
   ```
2. Navigate to the project directory:
   ```sh
   cd softway-clinic
   ```
3. Build and run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Access the API at:
   ```
   GET http://localhost:8080/api/diagnosis/{index}
   ```

## API Endpoints
### `GET /api/diagnosis/{index}`
Retrieves a pathology diagnosis for a given health index.

#### Example Requests:
```sh
curl -X GET "http://localhost:8080/api/diagnosis/33"
```
#### Responses:
- **200 OK**: Returns a `PathologyDTO` object with the diagnosis.
- **400 Bad Request**: If an invalid index is provided (e.g., negative or non-numeric values).

## Testing
### Running Unit and Integration Tests
To run all tests, execute:
```sh
mvn test
```

### Unit Tests
- `DiagnosisServiceTest`: Verifies the logic in `DiagnosisService`.

### Integration Tests
- `DiagnosisControllerIntegrationTest`: Tests the REST API behavior using `MockMvc`.

## Error Handling
- Invalid indices return a `400 Bad Request` error with relevant details.
- Example:
  ```json
  {
    "errorClass": "IllegalArgumentException",
    "status": "BAD_REQUEST",
    "message": "Health index must be positive"
  }
  ```

## Contact
For any issues or contributions, feel free to open a pull request or contact the project maintainer.

