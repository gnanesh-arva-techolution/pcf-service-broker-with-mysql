# hashmap-service-broker

## Problem
->  Write a service broker for cloud foundry that provides a HashMap to be used by CF applications.
Once the service broker is registered on CF any application developed for CF should be able to use the service.

## Pre-Requisite
-> Java 1.7 or higher, Pivotal Cloud Foundary PCF DEV, (MYSQL is not required here), CF CLI, VirtualBox: 5.0+

## Steps
-> First install the PCF DEV for your operating system as per the instructions provided in the url https://pivotal.io/academy/course/introduction-to-pivotal-cloud-foundry

-> After installing the PCF DEV.Start the PCF DEV using the command cf dev start

-> Once PCF is started login to cf using your credentials cf login -a https://api.local.pcfdev.io --skip-ssl-validation Enter your username and password

-> Clone the repository git clone https://github.com/shyamjumberi/hashmap-service-broker.git

-> Go To the servive-broker-hasmap project and run the following command to build the project

     mvn clean package -DskipTests

-> Now push the service on the PCF DEV using cf push command it will read the configuration from manifest.yml file of the project.

-> Once the app is running, register the broker with the Cloud Controller (substitute the route for your broker app):

    cf create-service-broker hashmap-service-broker username password http://hashmap-service-broker.local.pcfdev.io
	
	Use --space-scoped option for making the service available for the current space which you are in.


-> You should now be able to see your service in the marketplace: cf marketplace

-> Next, create an instance of your service:

    cf create-service service-name basic custom-hash

-> Now it’s time to push and bind to the client app. Go to hashmap-service-broker-client and run

    mvn clean package -DskipTests

-> We’ll use a CF application manifest to take care of our metadata, including binding to the hashmap-service service.

-> Now push the client app using : cf push

-> Once the application is running, you can test it:

    http://route-of-your-client-application/HashBroker/{key-name}

-> This is PUT operation

 Now put some value in this key for ex {"value":"bar"}

 Now perform the GET call on the key to fetch the value

    http://route-of-your-client-application/HashBroker/{key-name} it will return value.
