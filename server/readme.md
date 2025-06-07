# Spring Boot Generic CRUD Framework

Un framework generico per Spring Boot che fornisce operazioni CRUD di base con mapping automatico tra entità JPA e DTO, riducendo il boilerplate code e accelerando lo sviluppo.

## Caratteristiche

- ✨ Operazioni CRUD complete out-of-the-box
- 🔄 Mapping automatico tra Entity e DTO
- 📄 Paginazione integrata
- 🎯 Struttura modulare e estensibile
- 🛡️ Gestione errori centralizzata
- 📝 Timestamp automatici (creazione/aggiornamento)

## Struttura del Framework

### Classi Base

- **BaseEntity**: Classe base per tutte le entità JPA
- **BaseDTO**: Classe base per tutti i DTO
- **GenericController**: Controller REST generico con endpoint CRUD
- **GenericService**: Interfaccia per servizi generici
- **GenericServiceImpl**: Implementazione base dei servizi
- **GenericRepository**: Repository JPA generico
- **GenericMapper**: Interfaccia per mapping Entity ↔ DTO

## Quick Start

### 1. Creazione dell'Entità

```java
@Entity
@Table(name = "users")
public class User extends BaseEntity {
    
    @Column(nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(unique = true, nullable = false)
    private String email;
    
    // Constructors, getters, setters
    public User() {}
    
    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    // Getters and Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
```

### 2. Creazione del DTO

```java
@Getter
@Setter
public class UserDto extends BaseDTO {
    
    private String firstName;
    private String lastName;
    private String email;
    
    // Constructors
    public UserDto() {}
    
    public UserDto(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
```

### 3. Creazione del Mapper

```java
@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<UserDto, User> {
    
    @Override
    User toEntity(UserDto dto);
    
    @Override
    UserDto toDto(User entity);
    
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    UserDto updateEntityFromDto(UserDto dto, @MappingTarget User entity);
}
```

### 4. Creazione del Repository

```java
@Repository
public interface UserRepository extends GenericRepository<User> {
    
    // Metodi custom aggiuntivi (opzionali)
    Optional<User> findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.lastName = :lastName")
    List<User> findByLastName(@Param("lastName") String lastName);
}
```

### 5. Creazione del Service

```java
public interface UserService extends GenericService<UserDto, User> {
    
    // Metodi custom aggiuntivi (opzionali)
    UserDto findByEmail(String email);
    List<UserDto> findByLastName(String lastName);
}
```

### 6. Implementazione del Service

```java
@Service
@Transactional
public class UserServiceImpl extends GenericServiceImpl<UserDto, User> implements UserService {
    
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    
    public UserServiceImpl(UserRepository repository, UserMapper mapper) {
        super(repository, mapper);
        this.userRepository = repository;
        this.userMapper = mapper;
    }
    
    // Implementazione metodi custom
    @Override
    public UserDto findByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        return userMapper.toDto(user);
    }
    
    @Override
    public List<UserDto> findByLastName(String lastName) {
        List<User> users = userRepository.findByLastName(lastName);
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
}
```

### 7. Creazione del Controller

```java
@RestController
@RequestMapping("/api/users")
public class UserController extends GenericController<UserDto> {
    
    private final UserService userService;
    
    public UserController(UserService service) {
        super(service);
        this.userService = service;
    }
    
    // Endpoint custom aggiuntivi (opzionali)
    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseDto<UserDto>> findByEmail(@PathVariable String email) {
        UserDto user = userService.findByEmail(email);
        return ResponseEntity.ok(new ResponseDto<>(true, "User found", user));
    }
    
    @GetMapping("/lastname/{lastName}")
    public ResponseEntity<ResponseDto<List<UserDto>>> findByLastName(@PathVariable String lastName) {
        List<UserDto> users = userService.findByLastName(lastName);
        return ResponseEntity.ok(new ResponseDto<>(true, "Users found", users));
    }
}
```

## Endpoint Disponibili

Il framework fornisce automaticamente i seguenti endpoint REST:

| Metodo | Endpoint | Descrizione |
|--------|----------|-------------|
| POST | `/api/{entity}` | Crea una nuova entità |
| GET | `/api/{entity}/{id}` | Recupera entità per ID |
| GET | `/api/{entity}` | Recupera tutte le entità (con paginazione) |
| PUT | `/api/{entity}/{id}` | Aggiorna entità esistente |
| DELETE | `/api/{entity}/{id}` | Elimina entità |

### Esempi di Chiamate API

#### Creare un nuovo utente
```bash
POST /api/users
Content-Type: application/json

{
    "firstName": "Mario",
    "lastName": "Rossi",
    "email": "mario.rossi@email.com"
}
```

#### Recuperare un utente per ID
```bash
GET /api/users/1
```

#### Recuperare tutti gli utenti con paginazione
```bash
GET /api/users?page=0&size=10&sort=lastName,asc
```

#### Aggiornare un utente
```bash
PUT /api/users/1
Content-Type: application/json

{
    "firstName": "Mario",
    "lastName": "Bianchi",
    "email": "mario.bianchi@email.com"
}
```

#### Eliminare un utente
```bash
DELETE /api/users/1
```

## Struttura Response

Tutte le response seguono il formato standardizzato:

```json
{
    "success": true,
    "message": "Operation completed successfully",
    "data": {
        "id": 1,
        "firstName": "Mario",
        "lastName": "Rossi",
        "email": "mario.rossi@email.com",
        "createdAt": "2024-01-15T10:30:00",
        "updatedAt": "2024-01-15T10:30:00"
    }
}
```

## Dipendenze Richieste

Aggiungi le seguenti dipendenze al tuo `pom.xml`:

```xml
<dependencies>
    <!-- Spring Boot Starters -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    
    <!-- Database -->
    <dependency>
        <groupId>com.h2database</groupId>
        <artifactId>h2</artifactId>
        <scope>runtime</scope>
    </dependency>
    
    <!-- MapStruct per mapping -->
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct</artifactId>
        <version>1.5.5.Final</version>
    </dependency>
    
    <dependency>
        <groupId>org.mapstruct</groupId>
        <artifactId>mapstruct-processor</artifactId>
        <version>1.5.5.Final</version>
        <scope>provided</scope>
    </dependency>
    
    <!-- Lombok -->
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

## Configurazione

Configura il database nel tuo `application.yml`:

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password: password
    
  jpa:
    database-platform: org.hibernate.dialect.H2Dialect
    hibernate:
      ddl-auto: create-drop
    show-sql: true
    
  h2:
    console:
      enabled: true
```

## Personalizzazioni Avanzate

### Validazione Custom

Aggiungi annotazioni di validazione ai tuoi DTO:

```java
@Getter
@Setter
public class UserDto extends BaseDTO {
    
    @NotBlank(message = "First name is required")
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String lastName;
    
    @Email(message = "Please provide a valid email")
    @NotBlank(message = "Email is required")
    private String email;
}
```

### Gestione Eccezioni Custom

Crea un handler globale per le eccezioni:

```java
@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseDto<Void>> handleRuntimeException(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ResponseDto<>(false, ex.getMessage(), null));
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDto<Void>> handleValidationException(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(", "));
        
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto<>(false, message, null));
    }
}
```

## Contributi

I contributi sono benvenuti! Per favore:

1. Fai un fork del progetto
2. Crea un branch per la tua feature (`git checkout -b feature/AmazingFeature`)
3. Committa le tue modifiche (`git commit -m 'Add some AmazingFeature'`)
4. Pusha sul branch (`git push origin feature/AmazingFeature`)
5. Apri una Pull Request

## Licenza

Questo progetto è distribuito sotto la licenza MIT. Vedi `LICENSE` per maggiori informazioni.

## Contatti

- Email: s.macinaleone@gmail.com
- LinkedIn: www.linkedin.com/in/stefano-macina-leone-239003174/
- website: www.stefanomacinaleone.it

---

⭐ Se questo progetto ti è stato utile, considera di lasciare una stella!