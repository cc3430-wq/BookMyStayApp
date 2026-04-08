# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 11: Concurrent Booking Simulation (Thread Safety)
Goal: Demonstrate how concurrent access to shared resources can lead to inconsistent system state and show how synchronization ensures correctness under multi-user conditions.
Actor:
Multiple Guests – submit booking requests concurrently.
Concurrent Booking Processor – processes booking requests in a multi-threaded environment.
Flow:
Multiple guests submit booking requests simultaneously.
Requests are added to a shared booking queue.
Threads retrieve requests using synchronized access.
Room allocation and inventory updates are performed inside critical sections.
The system completes allocations without conflicts or inconsistencies.