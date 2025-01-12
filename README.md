#  PayPal Payment Integration Application
![SPRING](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![SPRING BOOT](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
![MAVEN](https://img.shields.io/badge/apache_maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![BOOTSTRAP](https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)

This is a PayPal payment integration web application built using Spring Boot, bootstrap , Thymeleaf, and MVC architecture. The application allows users to intiate a payment through a web interface.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Gallery](#Gallery)
- [Setup](#setup)
- [Running the Application](#running-the-application)
- [Usage](#usage)


## Introduction

This project is a simple web-based application that demonstrates the PayPal payment integration using Spring Boot . Thymeleaf is used as the template engine for rendering views, and the application follows the MVC (Model-View-Controller) architecture to separate concerns.

## Features

- Initiate Payments: Users can initiate payments directly from the web interface using PayPal.
- Multi-Currency Support: Allow users to make payments in various currencies supported by PayPal.
- Dynamic Error Handling: Informative error messages for failed transactions .
- User-friendly : Good looking web user interface.

## Technologies Used

- Spring Boot : To build the backend services, implement business logic
- Spring MVC  : For implementing the Model-View-Controller architecture.
- Thymeleaf :  the template engine for rendering dynamic views and handling server-side data binding.
- Bootstrap :  For user friendly design and styling the application interface.
- PayPal SDK/APIs : For integrating payment functionality.

## Prerequisites

- IDE ( VScode , Intellij , Eclipse , etc .. )
- Java 11 or higher
- Maven

## Gallery

<div>
<img src="https://github.com/sharkblue58/paypal-integration/blob/main/src/main/resources/static/images/1.png" width="200">
</div>

## Setup

1. **Clone the repository:**

    ```bash
    git clone https://github.com/your-username/paypal-integration.git
    cd paypal-integration
    ```

2. **Configure the PayPal:**

    Create a app in your paypal dashboard and update the `application.yml` file with your paypal credentials.

    ```properties
    spring:
      application:
        name: paypal-integration
    paypal:
      client-id: YOUR_ID
      client-secret: YOUR_SECRET
      mode: YOUR_MODE (sandbox or live)
    server:
      error:
        whitelabel:
          enabled : false      
    ```

3. **Build the project:**

    ```bash
    mvn clean install
    ```

## Running the Application

Run the application using the following command:

```bash
mvn spring-boot:run
```

## Usage

The project can be accessed at ```http://127.0.0.1:8000``` in your browser.
