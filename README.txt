### ENDPOINT

### EXEMPLE OF USE


#### REPOSITORY

1. METHOD - GET
	- http://localhost:8080/contatos - RETURN A LIST OF CONTACTS
	- http://localhost:8080/usuarios - RETURN A LIST OF USERS

2. METHOD - POST
	- http://localhost:8080/contatos - RETURN A LIST OF CONTACTS
	json body:
	{
	"name":"teste",
	"phoneHome": ["54564646"]
    }
    
    
    

	- http://localhost:8080/usuarios - RETURN A LIST OF USERS
	json body:
	{	
		"name": "JACK",
		"age": 21
	}	
	
	or with list(first add one contact
    {	
		"name": "JACK2",
		"age": 21,
		"list": [
			"http://localhost:9001/contatos/1"
		]
	}

#### CONTROLER


1. METHOD - GET
	http://localhost:8080/user/search?nameUser=fulano - search user by name with RequesParam
	http://localhost:8080/user/searchPath/{name} - search user by name with @PathVariable

	http://localhost:8080/contact/search?id= - search contact by name with RequesParam


2. METHOD - POST

	http://localhost:8080/contact/{userId}
	json e.g:
	
	{
	"name":"new contact for user 1",
	"phoneHome": ["35545545"]
	}