# SCS
Webtech project
Names: Ishimwe Thierry
 
Student I.D: 23756
 
 	 	  WEB-TECHNOLOGY FINAL PROJECT  
 
[ PART 1] 
 
1.	Describe key features of web application functional + non-functional requirements. 
 
2.	Web-UI with menu to access those key features (min 3 functional, and 2 non-functional). 
 
Problem 
 
The problem that this system can solve is to provide parents with timely and accurate information about their children's behavior in school. This system can help improve communication between schools and parents, which can result in a better understanding of the student's needs, strengths, and weaknesses. It can also enable parents to work together with teachers to support their child's academic and social development. Ultimately, this system can enhance the educational experience for students and promote positive outcomes.
 
What Web application solution do I propose to this problem? 
 
User Accounts: The web application would have user accounts for parents, teachers, and school administrators. Each user would have their login credentials, and the access level would vary depending on their role.
Dashboard: The dashboard would be the main page of the application, and it would show the latest information about the student's behavior, including attendance, grades, and any incidents or disciplinary actions.
Communication: The web application would have a communication feature that allows teachers and parents to communicate through the platform. This feature would make it easy for teachers to provide updates on a student's behavior, and for parents to ask questions or provide feedback.
Notification: The web application would have a notification feature that sends alerts to parents whenever there is a change in their child's behavior or a new message from the teacher. This feature would help parents stay informed and involved in their child's education.
Reports: The web application would have a reporting feature that generates reports on a student's behavior and academic performance. These reports would be useful for parents, teachers, and school administrators to track a student's progress over time.
Overall, this web application would help parents stay informed about their child's behavior in school, enabling them to take a more active role in their child's education. It would also help teachers and school administrators to communicate more effectively with parents, which can lead to better outcomes for students.

Functional Requirements  

User Authentication and Authorization: The web application should provide user authentication and authorization to ensure that only authorized users can access the information related to the specific child.
Student Profiles: The web application should provide a feature to maintain student profiles with information such as the name, grade level, attendance, behavior incidents, academic performance, etc.
Messaging System: The web application should have a messaging system that allows teachers and school administrators to send messages to parents about their child's behavior, academic performance, attendance, and other important updates.
Notifications: The web application should provide a notification system that sends alerts to parents whenever there is a change in their child's behavior or academic performance. This can include notifications for missed assignments, upcoming tests, and disciplinary actions.
Reports: The web application should generate reports on a student's behavior and academic performance. The reports should include detailed information about the student's attendance, behavior, academic performance, and other important metrics.
Parent-Teacher Conference Scheduling: The web application should allow parents to schedule appointments with teachers for parent-teacher conferences to discuss their child's progress, behavior, and other related concerns.
Data Privacy and Security: The web application should ensure data privacy and security by implementing appropriate measures such as secure login, data encryption, access controls, and audit logs.
Accessible and User-friendly Interface: The web application should be accessible and user-friendly, allowing parents, teachers, and school administrators to easily navigate and interact with the system.
These functional requirements can help ensure that the web application is capable of providing timely and accurate information about a student's behavior, academic performance, and related concerns to parents, teachers, and school administrators.
Non-functional requirements 
 
Performance: The web application should be responsive and provide a fast user experience. It should be able to handle a large number of users and provide timely information to parents, teachers, and school administrators.
Scalability: The web application should be scalable and able to handle a growing number of users and data.

Reliability: The web application should be reliable and available 24/7. It should have a backup and recovery plan in case of system failures or data loss.
Security: The web application should ensure data privacy and security by implementing appropriate security measures such as secure login, data encryption, access controls, and audit logs.
Usability: The web application should be user-friendly and easy to use. It should provide clear and concise information to parents, teachers, and school administrators.
Accessibility: The web application should be accessible to users with disabilities. It should comply with accessibility guidelines such as WCAG 2.0.
Interoperability: The web application should be able to integrate with other school systems such as student information systems, learning management systems, and assessment systems.
Maintenance: The web application should be easy to maintain and update. It should have clear documentation and support from the development team.
These non-functional requirements can help ensure that the web application is reliable, secure, and user-friendly, providing a seamless and effective communication platform between parents, teachers, and school administrators.
Screenshots/ workflow 
 
 
1.	The system shall provide signup system for new students to register new accounts. 
 
 
  

 
2.	The system must provide login system for returning university students with accounts. 
 
 
Login form 


 


After Logging into Student Account

 
 
 
 
 
 
 

3.	The system shall provide a login system for the admin where they shall add, 
delete, view students to the database. 
 

  
 
 
 


 
After inserting I clicked Display to see if it was inserted 
  
a.	I can also delete using the Delete Button (I deleted the first record for demonstration) 
 
 
 
 
 
 
 
 
 
 
4.	The system shall provide the admin the capacity to view all students and to search for any student and admin can add conduct of students and comments about student’s behaviors.
 	 
Once logged in as admin you click on View submission 
 
  
 
 
 
 
Then parents or students can view all applications about students submitted by the admin or school: 
 
 
 

 

6. The system shall provide a home option to display available fields to website visitors. 
 
 

 
  


 
[ PART 2] 
 
Using MVC architecture implement each feature, and for each feature provide a screenshots demonstrating the implementation of Model, View and Controller components. Use Ajax at least in sending one request.  
 
Side Note: Before running the project please add the following jars: PostgreSQL and boots faces into the library in NetBeans (To avoid exceptions because we need to import them) 
 
 
 
I added them inside the folder so that you can find them 
side by side with my project 23756_Ishimwe_Thierry_WebTechProject 
 
 

 
 
[ PART 3 ] 
 
Implement at least 2 non-functional (non-domain specific) features of your webapplication.  
 
 
 
1.	Security: Students must have valid credentials to be authenticated. 
 
Here if I type a wrong password it will not allow to get into the account no matter how many tries 

 
  
 
 
 
There is also captcha verification for added security 
  
2.	Responsive UI: The web application is responsive to smaller screens  
a.	The navigation bar collapse with hamburger menu 
  
  

 
 
 
 
  
 
 
On the login side of both returning students and admin. 
 
Firstly I registered 
 
 
Implementation in the project: 
Inside my Login Bean (Login.java) class is where the validation is so that you must select the reCaptcha before logging in 
 

 
 
 
 
 
 
 
 
 
 
  
