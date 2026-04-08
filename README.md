# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 4: Room Search & Availability Check
Goal: Enable guests to view available rooms and their details without modifying system state, reinforcing safe data access and clear separation of responsibilities.
Actor:
Guest – initiates a search to view available room options.
Search Service – handles read-only access to inventory and room information.
Flow:
Guest initiates a room search request.
The system retrieves availability data from the inventory.
Room details and pricing are obtained from room objects.
Unavailable room types are filtered out.
Available room types and their details are displayed.
System state remains unchanged.