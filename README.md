# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
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