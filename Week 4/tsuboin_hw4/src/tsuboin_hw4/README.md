**HW4 Registration System README**

My solution is fully working, and the driver input matches the expected values,
with exception to Student Year which is based on our current year.

Justification for Additional Classes

* Person Class: Created superclass for Student and Faculty staff to hold common
  data fields like name and id number. Student and Faculty extended the person
  class and then I implemented the additional functionality needed for each.
* IdentificationNumber Class: Created a static utility class to keep track of
  the current ID number since Student and Faculty are assigned numbers from the
  same pool. Assumed linear increments by 1 was acceptable.

Design Decisions

* I decided to include toString utility classes for Classes that had most of
  their relevant data stored within itself (ie. course). These toString methods
  made printing to the console cleaner, so the Driver didn't have to use many
  getters to display information to screen. I did not include toString for
  Section because the course name could only be accessed from the registration
  system.

Assumptions

* Undergraduate students are in a 4-year degree.
* Faculty advisors are randomly assigned to students.
* A future client may need more setters in the Person classes to update a
  program or office. I initially wrote them but removed them as the
  specification requested no unnecessary methods.

Extra Credit

* Did not do the UML diagram.
* See optional Junit testing. 