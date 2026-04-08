# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 5: Booking Request (First-Come-First-Served)
Goal: Handle multiple booking requests fairly by introducing a request intake mechanism that preserves arrival order, reflecting real-world booking behavior during peak demand.
Actor:
Reservation – represents a guest’s intent to book a room.
Booking Request Queue – manages and orders incoming booking requests.
Flow:
Guest submits a booking request.
The request is added to the booking queue.
Requests are stored in arrival order.
Queued requests wait for processing by the allocation system.
No inventory mutation occurs at this stage.