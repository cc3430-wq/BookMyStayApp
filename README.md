# BookMyStayApp
 main
Use Case 2: Basic Room Types & Static Availability
Goal: Introduce object modeling through inheritance and abstraction before introducing data structures, allowing students to focus on domain design rather than optimization.

Actor: User – runs the application to view predefined room types and their availability.

Flow:

User runs the application.
Room objects representing different room types are created.
Availability for each room type is stored using simple variables.
Room details and availability information are printed to the console.
Application terminates.
Key Concepts Used
Abstract Class - An abstract class is used to represent a generalized concept that should not be instantiated directly. The Room class defines common attributes and behavior shared by all room types while enforcing a consistent structure.
Inheritance - Concrete room classes (SingleRoom, DoubleRoom, SuiteRoom) extend the abstract Room class. This allows shared properties to be reused while enabling specialization for each room type.
Polymorphism - Room objects are referenced using the Room type, enabling uniform handling of different room implementations. This prepares the system for future extensibility without changing client code.
Encapsulation - Room attributes such as number of beds, size, and price are encapsulated within the Room class. This ensures that room characteristics are controlled and modified only through defined behavior.
Static Availability Representation - Room availability is stored using simple variables rather than data structures. This intentionally highlights the limitations of hardcoded and scattered state management.
Separation of Domain and State - Room objects represent what a room is, while availability variables represent current system state. This distinction becomes critical when inventory management is introduced later.
Key Requirements
Define an abstract Room class with common attributes.
Create concrete room classes for Single, Double, and Suite rooms.
Initialize room objects in the application entry point.
Store room availability using individual variables.
Display room details and availability to the console.
Key Benefits
Clear introduction to object-oriented domain modeling
Demonstrates inheritance and abstraction in a real-world context
Establishes a strong foundation for later inventory refactoring
Drawbacks of Previous Use Case
Use Case 1 focused only on application startup and execution flow.
No domain modeling or business concepts were introduced, limiting system realism.
=======
Use Case 3: Centralized Room Inventory Management
Goal: Introduce centralized inventory management by replacing scattered availability variables with a single, consistent data structure, demonstrating how HashMap solves real-world state management problems.

Actor: RoomInventory – responsible for managing and exposing room availability across the system.

Flow:

The system initializes the inventory component.
Room types are registered with their available counts.
Availability is stored and retrieved from a centralized HashMap.
Updates to availability are performed through controlled methods.
The current inventory state is displayed when requested.
Key Concepts Used
Problem of Scattered State - In the previous use case, availability was stored in separate variables. This leads to inconsistent updates, duplication, and poor scalability as the system grows.
HashMap - HashMap<String, Integer> is used to map room types to available room counts. This allows fast access, updates, and lookups based on a logical key.
O(1) Lookup - HashMap provides average constant-time complexity for get and put operations. This makes it suitable for systems that require frequent availability checks.
Single Source of Truth - All availability data is maintained in one centralized structure. This eliminates discrepancies caused by multiple variables representing the same state.
Encapsulation of Inventory Logic - Inventory-related operations are encapsulated within a dedicated class. Other parts of the system interact with inventory only through exposed methods, reducing coupling.
Separation of Concerns - Inventory manages how many rooms are available, not what a room is. Room characteristics such as price and size remain part of the Room domain model.
Scalability - Adding a new room type requires only inserting a new entry into the map. No changes are required in application logic, demonstrating scalable design.
Key Requirements
Initialize room availability using a constructor.
Store room availability using a HashMap.
Provide methods to retrieve current availability.
Support controlled updates to room availability.
Ensure inventory state remains consistent across operations.
Key Benefits
Single source of truth for room availability
Constant-time inventory access and updates
Improved scalability when introducing new room types
Drawbacks of Previous Use Case
Availability was managed using independent variables.
This approach does not scale and increases the risk of inconsistent system state as complexity grows.
 dev
