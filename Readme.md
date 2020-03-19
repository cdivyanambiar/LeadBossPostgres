# LeadBoss

Lead management is essential for increase any kind of sales. Most of the companies will gather lead data from different channels like surveys, forms in media or other widgets. Also companies need more analytics on lead filtering, like response time form executive/sales person, their conversation, where the communication is lagging thus generate more revenue. Our software LeadBoss, a general CRM system to manage your leads without any dropout and it will be flexible to adapt any number (small scale and large scale business) of leads. We will be capturing leads from all sources which are available today. Also it will help the sales executive to manage their activities easily.

1. Create a database named `LeadBoss`.

2. Open `src/main/resources/application.properties` and change `spring.datasource.username` and `spring.datasource.password` properties as per your Postgresql installation.

3. Type `mvn spring-boot:run` from the root directory of the project to run the application.


## Support
GET : http://localhost:8080/leads

GET  : http://localhost:8080/leads/{id}

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
	"additionalLeadDetails": {
		"leadPriority": "LeadPriority1",
		"leadStatus": "LeadStatus1",
		"leadOwner": "LeadOwner1"
	},
	"followup": {
		"followupMedium": "Medium1",
		"date": "2020-02-21",
		"time": "10.00 AM"
	}
}
