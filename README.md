# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
UC10-BookingCancellation
Use Case 10: Booking Cancellation & Inventory Rollback
Goal: Enable safe cancellation of confirmed bookings by correctly reversing system state changes, ensuring inventory consistency and predictable recovery behavior.
Actor:
Guest – initiates a cancellation request for an existing booking.
Cancellation Service – validates cancellations and performs controlled rollback operations.
Flow:
Guest initiates a cancellation request.
The system validates the reservation to ensure it exists and is cancellable.
The allocated room ID is recorded in a rollback structure.
Inventory count for the corresponding room type is incremented.
Booking history is updated to reflect the cancellation.
System state is restored consistently.
=======
UC8-Booking History & Reporting
Goal: Introduce historical tracking of confirmed bookings to provide operational visibility, enable audits, and support reporting, reinforcing a persistence-oriented mindset without introducing external storage.
Actor:
Admin – reviews booking history and reports for operational purposes.
Booking History – maintains a record of confirmed reservations.
Booking Report Service – generates summaries and reports from stored booking data.
Flow:
A booking is successfully confirmed.
The confirmed reservation is added to booking history.
Booking history maintains records in insertion order.
Admin requests booking information or reports.
Stored reservations are retrieved and displayed as required.
main