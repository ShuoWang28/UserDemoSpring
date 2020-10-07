# UserDemoSpring
# Docker Instruction:

1. **docker build -t springio:userdemo https://github.com/ShuoWang28/UserDemoSpring.git#main**

2. **docker container run -d -p 8080:8080 springio:userdemo**

3. entry pages:
	* h2-console: localhost:8080/h2-console
	
	* list all users: http://localhost:8080/jpa/getAllUsers
	
	* Add a new user: /jpa/addNewUser
	
	* Update a user password: /jpa/updatePassword/{id}
	
	* Delete a user by id: /jpa/deleteUser/{id}
