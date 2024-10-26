# Restful Banking Application

A simple banking application built using Spring Boot that allows users to create accounts, deposit and withdraw amounts, and delete accounts. This application uses RESTful APIs for interaction and is structured to separate concerns between controllers, services, and repositories.

## Features

- Create bank accounts
- Retrieve account details
- Deposit and withdraw amounts
- Delete bank accounts
- Utilizes JPA for database operations with MySQL

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Lombok
- MySQL Database

## Setup Instructions

1. **Clone the repository:**
    ```bash
    git clone https://github.com/joshan-18/Restful-Banking-Application.git
    ```

2. **Open the project folder:**
    ```bash
    cd BankingApplication
    ```

3. **Configure the application:**
   - Open `src/main/resources/application.properties` and configure your MySQL database settings, for example:
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     ```

4. **Build the application:**
    ```bash
    mvnw.cmd clean install
    ```

5. **Run the application:**
    ```bash
    mvnw.cmd spring-boot:run
    ```

6. **Access the API:**
   - Open your browser or a tool like Postman to access the endpoints at `http://localhost:8080/api/accounts`.

## API Endpoints

- **Create Account**
  - **POST** `/api/accounts/createAccount`
  
- **Get Account by ID**
  - **GET** `/api/accounts/getAccount/{id}`
  
- **Get All Accounts**
  - **GET** `/api/accounts/getAccounts`
  
- **Deposit Amount**
  - **PUT** `/api/accounts/depositAmount/{id}`
  - **Request Body**: `{ "amount": <amount> }`
  
- **Withdraw Amount**
  - **PUT** `/api/accounts/withdrawAmount/{id}`
  - **Request Body**: `{ "amount": <amount> }`
  
- **Delete Account**
  - **DELETE** `/api/accounts/deleteAccount/{id}`

## Contributing

Feel free to fork this repository and submit pull requests for any improvements or additional features!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments

- Spring Boot documentation
- Stack Overflow community
- Any other resources you found helpful
