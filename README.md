## Ejecutar en Docker
```bash
docker compose up --build -d && docker compose logs -f app
```

## Estructura del Proyecto

```
.
├───.env
├───.env.example
├───.gitattributes
├───.gitignore
├───docker-compose.yaml
├───Dockerfile
├───mvnw
├───mvnw.cmd
├───pom.xml
├───README.md
└───src/
    ├───main/
    │   ├───java/
    │   │   └───com/robinlb99/pruebatecnica/
    │   │               ├───PruebaTecnicaIguanDigitalApplication.java
    │   │               ├───common/
    │   │               │   ├───config/
    │   │               │   ├───dto/
    │   │               │   ├───exception/
    │   │               │   ├───mapper/
    │   │               │   └───util/
    │   │               └───feature/
    │   │                   ├───employee/
    │   │                   │   ├───controller/
    │   │                   │   │   └───EmployeeController.java
    │   │                   │   ├───exception/
    │   │                   │   │   └───EmployeeNotFoundException.java
    │   │                   │   ├───mapper/
    │   │                   │   │   └───EmployeeMapper.java
    │   │                   │   ├───model/
    │   │                   │   │   ├───dto/
    │   │                   │   │   │   ├───EmployeeRequestDTO.java
    │   │                   │   │   │   └───EmployeeResponseDTO.java
    │   │                   │   │   └───entity/
    │   │                   │   │       └───Employee.java
    │   │                   │   ├───repository/
    │   │                   │   │   ├───EmployeeDAOImpl.java
    │   │                   │   │   ├───EmployeeRepository.java
    │   │                   │   │   └───dao/
    │   │                   │   │       └───EmployeeDAO.java
    │   │                   │   └───service/
    │   │                   │       ├───EmployeeServiceImpl.java
    │   │                   │       └───contract/
    │   │                   │           └───EmployeeService.java
    │   │                   └───otherfeature/
    │   └───resources/
    │       ├───application.properties
    │       ├───static/
    │       └───templates/
    └───test/
        └───java/
            └───com/
                └───robinlb99/
                    └───pruebatecnica/
                        └───PruebaTecnicaIguanDigitalApplicationTests.java
```