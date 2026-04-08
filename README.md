# BookMyStayApp
This project presents the design and implementation of a Hotel Booking Management System to illustrate the practical application of Core Java and fundamental data structures in real-world scenarios
Use Case 12: Data Persistence & System Recovery
Goal: Introduce persistence and recovery concepts by ensuring that critical system state survives application restarts, transitioning learners from in-memory thinking to durable system design.
Actor:
System – initiates save and restore operations during shutdown and startup.
Persistence Service – handles storing and retrieving system state from persistent storage.
Flow:
The system prepares for shutdown.
Current booking and inventory state is serialized into a persistent format.
Serialized data is written to a file.
System restarts.
Persisted data is loaded from the file.
Inventory and booking state are restored into memory.
System resumes operation with recovered state.