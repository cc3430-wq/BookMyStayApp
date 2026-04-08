# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 9: Error Handling & Validation
Goal: Strengthen system reliability by introducing structured validation and error handling, ensuring that invalid inputs and inconsistent states are detected and handled early.
Actor:
Guest – provides booking input that must be validated.
Invalid Booking Validator – validates input and system state before processing requests.
Flow:
Guest provides booking input.
System validates input values and system constraints.
If validation fails, an error is raised immediately.
A meaningful failure message is displayed.
The system prevents invalid state changes and continues running safely.