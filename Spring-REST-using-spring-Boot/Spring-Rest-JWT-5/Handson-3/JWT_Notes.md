# Spring-Rest-JWT Handson-3 : Understanding JWT

## 1. Objective
Learn:
- What is JWT?
- Why JWT is used?
- JWT Authentication Flow
- JWT Structure
- How a JWT Token is generated
  - Base64 Encoding
  - Header
  - Payload
  - Signature

## 2. What is JWT?
JWT (JSON Web Token) is an open standard (RFC 7519) used to securely transmit information between a client and a server as a JSON object.
A JWT token proves that the user has already authenticated, so the user does not need to send their username and password with every request.

## 3. Why JWT?
Without JWT:
Client -> Username + Password -> Server -> Every Request again -> Username + Password
The username and password travel with every request, which is less secure and inefficient.

With JWT:
Client -> Username + Password -> Server -> JWT Token -> Client Stores Token -> Subsequent Requests -> Bearer Token -> Server Validates Token
The password is sent only once, and all future requests use the JWT token.

## 4. JWT Process Flow
```text
                +----------------------+
                |       Client         |
                +----------------------+
                          |
                          | Username + Password
                          |
                          ▼
                +----------------------+
                |       Server         |
                +----------------------+
                          |
                 Validate Credentials
                          |
                          ▼
                 Generate JWT Token
                          |
                          ▼
                Return JWT Token
                          |
                          ▼
                +----------------------+
                |       Client         |
                +----------------------+
                          |
               Authorization: Bearer JWT
                          |
                          ▼
                +----------------------+
                |       Server         |
                +----------------------+
                          |
                   Validate JWT Token
                          |
                          ▼
                     Return Response
```

## 5. JWT Structure
A JWT consists of three parts separated by dots (.).
`Header.Payload.Signature`

Example
```text
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiJ1c2VyIiwicm9sZSI6IlVTRVIifQ.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

## 6. JWT Components
### Header
Contains information about the token.
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```
Meaning:
- alg -> Encryption algorithm (HS256)
- typ -> Token type (JWT)

### Payload
Contains user information.
```json
{
  "sub": "user",
  "role": "USER"
}
```
Possible fields:
- User ID
- Username
- Email
- Roles
- Expiry Time

### Signature
The signature ensures that the token has not been modified.
It is created using:
`HMACSHA256(Base64Url(Header) + "." + Base64Url(Payload), SecretKey)`
Only the server knows the Secret Key, so attackers cannot generate valid tokens.

## 7. JWT Example
**Header**
```json
{
  "alg": "HS256",
  "typ": "JWT"
}
```

**Payload**
```json
{
  "sub":"user",
  "role":"USER"
}
```

**Generated JWT**
```text
eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
eyJzdWIiOiJ1c2VyIiwicm9sZSI6IlVTRVIifQ.
SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c
```

## 8. How to Verify JWT
- Step 1: Open https://jwt.io
- Step 2: Scroll to Debugger
- Step 3: Paste Header
- Step 4: Paste Payload
- Step 5: Enter Secret (`secretkey`)
- Step 6: JWT.io automatically generates `Header.Payload.Signature`

## 9. JWT vs Basic Authentication
| Basic Authentication | JWT Authentication |
|---|---|
| Username & Password sent on every request | Username & Password sent only once |
| Uses Base64 encoding | Uses signed JWT token |
| Less secure | More secure |
| Stateful authentication | Stateless authentication |
| Credentials repeatedly exposed | Token reused until expiration |

## 10. Advantages of JWT
- Stateless authentication
- More secure than Basic Authentication
- No repeated transmission of passwords
- Compact and lightweight
- Supports distributed systems
- Easy to use with REST APIs
- Includes expiration time
- Can carry user roles and claims
