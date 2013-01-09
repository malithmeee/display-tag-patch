About
#####
How implement client side search functionality on a table generated using displaytag java library

Base Project Creation
#####################
mvn archetype:create -DgroupId=com.bdot -DartifactId=displaytag-search
pom.xml -> change packaging type to pom so that multiple modules can be added
delete src folder as we don't need it

Add displaytag-header patch
###########################
Go to the project folder
mvn archetype:create -DgroupId=com.bdot -DartifactId=displaytag-header-patch

Adding Web application
######################
Go to the project folder
mvn archetype:create -DgroupId=com.bdot -DartifactId=displaytag-search-webapp -DarchetypeGroupId=org.apache.struts -DarchetypeArtifactId=struts2-archetype-starter -DarchetypeVersion=2.2.1

How to run
##########
Compile
	mvn clean install   -> Run this from root directory

Run
	From root directory
		mvn jetty:run-war
	(or) 
	From webapp directory
	cd displaytag-search-webapp
	mvn jetty:run