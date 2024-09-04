# Account Transfer RESTful API

## Overview

This project implements a RESTful API for performing transfers between accounts. The API allows users to transfer funds between accounts by specifying the source account number, destination account number, and the transfer amount. The data is managed in-memory, and no user interface or authentication is required for this case study.

## Technologies Used

- **Programming Language**: Java
- **Web Framework**: Spring Boot 
- **In-Memory Data Storage**: Managed in-memory without any external database

## Features

- Perform fund transfers between accounts.
- Validate transactions to ensure sufficient funds are available.
- Maintain account balances.
- In-memory data storage for accounts and transactions.


## Data Models

### 1. Account

- **Account Number**: Unique identifier for the account.
- **Balance**: The current balance of the account.

### 2. Transaction

- **Source Account Number**: The account number from which funds are being transferred.
- **Destination Account Number**: The account number to which funds are being transferred.
- **Amount**: The amount of money to be transferred.

## API Endpoints

### 1. Transfer Funds

- **Endpoint**: `/api/v1/transactions`
- **Method**: `POST`
- **Request Body**:
  ```json
  {
    "sourceAccount": "string",
    "destinationAccount": "string",
    "amount": "decimal"
  }
### 2. Get Account Details

- **Endpoint**: `/api/v1/accounts/{accountNumber}`
- **Method**: `GET`


