# LeadBoss

Lead management is essential for increase any kind of sales. Most of the companies will gather lead data from different channels like surveys, forms in media or other widgets. Also companies need more analytics on lead filtering, like response time form executive/sales person, their conversation, where the communication is lagging thus generate more revenue. Our software LeadBoss, a general CRM system to manage your leads without any dropout and it will be flexible to adapt any number (small scale and large scale business) of leads. We will be capturing leads from all sources which are available today. Also it will help the sales executive to manage their activities easily.

1. Create a database named `LeadBoss`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your Postgresql installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Support
# Lead
=======
GET: http://localhost:8080/leads

GET: http://localhost:8080/leads/{id}

POST: http://localhost:8080/leads

Delete: http://localhost:8080/leads

Delete: http://localhost:8080/leads/{1}

Payload for POST :

{
	"leadSource": "LeadSource1",
	"leadType": "LeadType2",
	"dateOfAddition": "2020-03-09",
	"occupancyStatus": "OccupancyStatus1",
	"leadInterest": "LeadInterest1",
	"clinicalIntensity": "ClinicalIntensity1",
	"firstName": "Divya",
	"lastName": "N",
	"gender": "Female",
	"emailAddress": "dn@gmail.com",
	"phoneNumber": "1111111111",
	"additionalNotes": "Good",
	"country":"India",
	"dosc":"2020-03-09",
	"docc":"2020-03-19",
	"additionalLeadDetails": {
		"leadPriority": "LeadPriority1",
		"leadStatus": "LeadStatus1",
		"leadOwner": "LeadOwner1"
	}
}

# EMAIL
========

GET: http://localhost:8080/emails

GET: http://localhost:8080/email/{id}

POST: http://localhost:8080/email

Delete: http://localhost:8080/emails

Delete: http://localhost:8080/email/{1}

# POST BODY for email
=======================
{
"sendTo": "to@gamil.com",
"sendFrom":"from@gmail.com",
"subject": "Test",
"dateOfEmail": "2020-02-30",
"message": "Hi How are you?"
}

#smtp details 
=============

spring.mail.protocol=smtp
## We have to change here with actual SMTP 
spring.mail.host=smtp.mailtrap.io
spring.mail.port=2525
spring.mail.username=d03c450d0b4d4f
spring.mail.password=456635b4507251
spring.mail.properties.mail.smtp.auth = true
spring.mail.properties.mail.smtp.starttls.enable = true

# FOLLOW UP
==============

POST: http://localhost:8081/lead/{lead_id}/followup

GET: http://localhost:8081/lead/{lead_id}/followups

GET: http://localhost:8081/lead/{lead_id}/followup/{id}

DELETE: http://localhost:8081/lead/{lead_id}/followup/{id}

UPDATE: http://localhost:8081/lead/{lead_id}/followup/{id}

# POST BODY for followup
===========
{
	"owner": "LeadSource1",
	"subject": "LeadType2",
	"starttime":"2020-02-30",
	"endtime":"2020-02-30",
	"recuring":1,
	"recuring_period":"week",
	"remainder":0,
	"remainer_period":"15 min",
	"description":"desc",
	"organizer":"LS1",
	"lead_id": 1
}

# Meeting
==============

POST: http://localhost:8081/lead/{lead_id}/meeting

GET: http://localhost:8081/lead/{lead_id}/meetings

GET: http://localhost:8081/lead/{lead_id}/meeting/{id}

DELETE: http://localhost:8081/lead/{lead_id}/meeting/{id}

UPDATE: http://localhost:8081/lead/{lead_id}/meeting/{id}

# POST BODY for meeting
===========
{
	"owner": "LeadSource1",
	"subject": "LeadType2",
	"starttime":"2020-02-30",
	"endtime":"2020-02-30",
	"recuring":1,
	"recuring_period":"week",
	"remainder":0,
	"remainer_period":"15 min",
	"description":"desc",
	"organizer":"LS1",
	"lead_id": 1
}

# Phone call
==============

POST: http://localhost:8081/lead/{lead_id}/phonecall

GET: http://localhost:8081/lead/{lead_id}/phonecalls

GET: http://localhost:8081/lead/{lead_id}/phonecall/{id}

DELETE: http://localhost:8081/lead/{lead_id}/phonecall/{id}

UPDATE: http://localhost:8081/lead/{lead_id}/phonecall/{id}

# POST BODY for phone call
===========
{
	"owner": "LeadSource1",
	"subject": "LeadType2",
	"starttime":"2020-02-30",
	"endtime":"2020-02-30",
	"recuring":1,
	"recuring_period":"week",
	"remainder":0,
	"remainer_period":"15 min",
	"description":"desc",
	"organizer":"LS1",
	"lead_id": 1
}

