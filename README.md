# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 7: Add-On Service Selection
Goal: Extend the booking model to support optional services, demonstrating how real-world business features can be added without modifying core booking or allocation logic.
Actor:
Guest – selects optional services for an existing reservation.
Add-On Service – represents an individual optional offering.
Add-On Service Manager – manages the association between reservations and selected services.
Flow:
Guest selects one or more add-on services.
Selected services are added to a list.
The list of services is mapped to the corresponding reservation ID.
Additional cost for the reservation is calculated.
Core booking and inventory state remain unchanged.