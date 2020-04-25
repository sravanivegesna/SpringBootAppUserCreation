**************************************************************
Details : This application exposes the spring boot CRUD application for User creation
**************************************************************


******
Note :
****** 
- This spring boot application is used to perform multiple operations on a user entity
and exposes API for CRUD operations

- Can also build UI with React JS for this.

******************************************************************
Procedure to bring the service UP
******************************************************************

1) Import the DB file (/db/user_db.sql) to database with name "user_db"

2) Perform mvn clean install and Start the spring boot app 

Below are endpoints exposed : 

3) Health Check Api 
   URL : http://localhost:5252/
   Type : GET
   Reponse: {
	"status":"SUCCESS",
	"errors":null,
	"data":"server is running"
	}
4)To get the list of all users information 
   URL : http://localhost:5252/users/
   Type : GET
   Response : {
    "status": "SUCCESS",
    "errors": null,
    "data": [
        {
            "id": 1,
            "email": "hello@gmail.com",
            "firstName": "matt",
            "lastName": "wood",
            "phoneNumber": "8014349887",
            "createdDate": "2020-04-20T00:00:00.000+0000"
        },
        {
            "id": 4,
            "email": "newemail.gmail.com",
            "firstName": "sam",
            "lastName": "jonson",
            "phoneNumber": "3434564356",
            "createdDate": "2000-01-13T00:00:00.000+0000"
        },
    ]
   }
   
5) API to view single User with UserId
   URL : http://localhost:5252/users/4
   Type : GET
   Reponse: {
    "status": "SUCCESS",
    "errors": null,
    "data": {
            "id": 4,
            "email": "newemail.gmail.com",
            "firstName": "sam",
            "lastName": "jonson",
            "phoneNumber": "3434564356",
            "createdDate": "2000-01-13T00:00:00.000+0000"
        }
}
  
5)  API to save the user
    URL : http://localhost:5252/users/
    Type : POST
    RequestBody: {
    		{
		"email": "sigh_jonsnow@gmail.com",
		"firstName": "jony",
		"lastName": "sigh_jonsnow",
		"phoneNumber": "432435234",
		"createdDateString": "2000-2-13"
	}
    Response : {
    		"status": "SUCCESS",
    		"errors": null,
    		"data": "inside save user method"
    } 


6) API to update the user
    URL : http://localhost:5252/users/7
    Type : PUT
    RequestBody: {
    		{
		"email": "newemail@gmail.com"
		}
    Response : {
    "status": "SUCCESS",
    "errors": null,
    "data": {
        "id": 7,
        "email": "newemail@gmail.com",
        "firstName": "mango",
        "lastName": "orange",
        "phoneNumber": "3434564356",
        "createdDateString": null,
        "createdDate": "2000-01-13T00:00:00.000+0000"
    }
}

7) API delete the user
     URL : http://localhost:5252/users/9
     Type : Delete
    	 Response : {
    		"status": "SUCCESS",
    		"errors": null,
    		"data": "Successfully deleted the row"
	 }