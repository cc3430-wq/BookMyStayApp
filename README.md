# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 6: Reservation Confirmation & Room Allocation
Goal: Confirm booking requests by assigning rooms safely while ensuring inventory consistency and preventing double-booking under all circumstances.
Actor:
Booking Service – processes queued booking requests and performs room allocation.
Inventory Service – maintains and updates room availability state.
Flow:
Booking request is dequeued from the request queue.
The system checks availability for the requested room type.
A unique room ID is generated and assigned.
The room ID is recorded to prevent reuse.
Inventory count is decremented immediately.
Reservation is confirmed.