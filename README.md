# Delivery Service Application

A Spring Boot web application to manage vehicles and items for a delivery service.  
Supports both **web UI** (Thymeleaf + Bootstrap) and **REST API** for integration.

---

## Features

- Manage Vehicles
  - Add, edit, delete, view vehicles
  - Filter by status or carrying weight
- Manage Items
  - Add, edit, delete, view items
  - Assign and remove items to/from vehicles
- REST API for CRUD operations
- Responsive web UI with Bootstrap

---

## Technologies

- Java 17+
- Spring Boot
- Spring Data JPA
- Hibernate
- Thymeleaf
- H2 (in-memory database for testing) or any other relational DB
- Maven
- Bootstrap 5

---

## Project Structure

com.example.delivery
│
├── controller # Web and API controllers
├── entity # JPA entities: Vehicle, Item
├── repository # Spring Data JPA repositories
├── service # Service interfaces
├── service.impl # Service implementations
├── resources
│ ├── templates # Thymeleaf templates (vehicles, items, forms)
│ └── application.properties
└── DeliveryServiceApplication.java




## Setup & Run

1. **Clone the repository**

```bash
git clone https://github.com/Esosa013/springboot-delivery.git

2. **Build the project**
mvn clean install

3. **Run the application**
mvn spring-boot:run

4. Access Web UI

Vehicles: http://localhost:8080/vehicles

Items: http://localhost:8080/items

Home Dashboard: http://localhost:8080/



5. **REST API Endpoints**
Vehicle API
Method	Endpoint	Description
GET	/api/vehicles	Get all vehicles
GET	/api/vehicles/plate/{plateNumber}	Get vehicle by plate number
GET	/api/vehicles/weight/{weight}	Get vehicles by minimum carrying weight
GET	/api/vehicles/status/{status}	Get vehicles by status
POST	/api/vehicles	Create a new vehicle
PUT	/api/vehicles/{id}	Update vehicle
DELETE	/api/vehicles/{id}	Delete vehicle
Item API
Method	Endpoint	Description
GET	/api/items	Get all items
GET	/api/items/code/{code}	Get item by code
POST	/api/items	Create a new item
PUT	/api/items/{id}	Update item
DELETE	/api/items/{id}	Delete item
POST	/api/items/{itemId}/assign/{vehicleId}	Assign item to a vehicle
POST	/api/items/{itemId}/remove	Remove item from vehicle
