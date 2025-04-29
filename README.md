# Ticket Manager – Backend API

This is the backend for the **Ticket Manager** project, built using Java with JAX-RS, JPA (Hibernate), and PostgreSQL.

## ✅ API Status

The API is **fully implemented** and ready for testing and integration.

## 🛠️ How to Run the API

### Requirements

- Java 17+
- Maven
- PostgreSQL (running locally)

### 1. Clone the repository

```bash
git clone https://your-backend-repo-url.git
cd backend
```

### 2. Configure Database Connection

Make sure you have a local PostgreSQL database named `ticket_manager` running with the following credentials (or update `persistence.xml` accordingly):

```xml
<persistence-unit name="dev" transaction-type="RESOURCE_LOCAL">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
    <properties>
        <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver" />
        <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/ticket_manager" />
        <property name="jakarta.persistence.jdbc.user" value="postgres" />
        <property name="jakarta.persistence.jdbc.password" value="0000" />
        <property name="jakarta.persistence.schema-generation.database.action" value="create" />
        <property name="jakarta.persistence.dialect" value="org.hibernate.dialect.PostgreSQLDialect" />
        <property name="hibernate.show_sql" value="true" />
    </properties>
</persistence-unit>
```

> This configuration will recreate the schema each time you restart the application.

### 3. Build and Run the Project

Use Maven to compile the project:

```bash
mvn clean install
```

Then run the main class `RestServer` located in the `rest` package:

```bash
mvn exec:java -Dexec.mainClass="rest.RestServer"
```

## 🧪 Testing the API

You can use **Postman** to test the API. All available endpoints are documented in the shared collection below:

🔗 **[Postman API Documentation](https://almamma.postman.co/workspace/ticketSIR~7c18ee85-d0e7-40f4-bd09-4e55ab5dab74/collection/19138390-8d381447-c607-45e9-bf47-66d5422390d2?action=share&creator=19138390)**

---

## 🌐 Frontend

The frontend is built using React and can be accessed from a separate repository.

### 1. Clone the Frontend Repository

```bash
git clone https://your-frontend-repo-url.git
cd frontend
```

### 2. Install Dependencies

```bash
npm install
```

### 3. Run the Frontend

```bash
npx serve
```

> The frontend expects the backend to be running on `http://localhost:8080` (or adjust the API base URL in the frontend accordingly).

---

## 📂 Structure

- `rest/`: REST API resources and `RestServer.java`
- `domain/`: JPA entities
- `dao/`: Request models and data access helpers
- `jpa/EntityManagerHelper.java`: Handles persistence context

---

Feel free to update credentials or endpoints based on your environment.

