# Highcharts Add-on for Vaadin 7

This project wraps the JavaScript library ... for use with Vaadin 7.

## Online demo

Try the add-on demo at <url of the online demo>

## Download release

Official releases of this add-on are available at Vaadin Directory. For Maven instructions, download and reviews, go to http://vaadin.com/addon/highcharts-vaadin7

## Download the source code

	git clone https://github.com/xylo/highcharts-vaadin7.git
	cd highcharts-vaadin7

## Building and running the demo in a standalone jetty server

	mvn clean install
	cd highcharts-demo
	mvn jetty:run

To see the demo, navigate to http://localhost:8081/

## Development with Intellij IDEA

For further development of this add-on, I recommend using Intellij IDEA and the following tool-chain:

- run the following commands:

		mvn clean package
		scripts/linkClasses.sh
		scripts/copyResources.sh

- install Tomcat and Intellij IDEA if not already done
- create a symlink in Tomcat's webapp directory to the ${SRC_DIR}/tomcat-wepapp
- restart tomcat and test the webapp
- start IDEA and chose ***File*** -> ***Import Project...***
  - select the directory of your local copy of this project
  - choose import from maven
- after importing the project copy the file scipts/settings.example.conf to scripts/settings.conf
- adapt scripts/settings.conf to the specifics of your system
- open the class `ReloadWebapp`, right click on it and choose ***Run 'ReloadWebapp.main()***

## Development with Eclipse

Development with Eclipse has not been tested.  Read the following at your own risk.

For further development of this add-on with Eclipse, you might want to use:
- m2e wtp plug-in (install it from Eclipse Marketplace)
- Vaadin Eclipse plug-in (install it from Eclipse Marketplace)
- JRebel Eclipse plug-in (install it from Eclipse Marketplace)
- Chrome browser

### Importing project

Choose File > Import... > Existing Maven Projects

Note that Eclipse may give "Plugin execution not covered by lifecycle configuration" errors for pom.xml. Use "Permanently mark goal resources in pom.xml as ignored in Eclipse build" quick-fix to mark these errors as permanently ignored in your project. Do not worry, the project still works fine. 

### Debugging server-side

If you have not already compiled the widgetset, do it now by running vaadin:install Maven target for highcharts-root project.

If you have a JRebel license, it makes on the fly code changes faster. Just add JRebel nature to your highcharts-demo project by clicking project with right mouse button and choosing JRebel > Add JRebel Nature

To debug project and make code modifications on the fly in the server-side, right-click the highcharts-demo project and choose Debug As > Debug on Server. Navigate to http://localhost:8080/highcharts-demo/ to see the application.

### Debugging client-side

The most common way of debugging and making changes to the client-side code is dev-mode. To create debug configuration for it, open highcharts-demo project properties and click "Create Development Mode Launch" button on the Vaadin tab. Right-click newly added "GWT development mode for highcharts-demo.launch" and choose Debug As > Debug Configurations... Open up Classpath tab for the development mode configuration and choose User Entries. Click Advanced... and select Add Folders. Choose Java and Resources under highcharts/src/main and click ok. Now you are ready to start debugging the client-side code by clicking debug. Click Launch Default Browser button in the GWT Development Mode in the launched application. Now you can modify and breakpoints to client-side classes and see changes by reloading the web page. 

Another way of debugging client-side is superdev mode. To enable it, uncomment devModeRedirectEnabled line from the end of DemoWidgetSet.gwt.xml located under highcharts-demo resources folder and compile the widgetset once by running vaadin:compile Maven target for highcharts-demo. Refresh highcharts-demo project resources by right clicking the project and choosing Refresh. Click "Create SuperDevMode Launch" button on the Vaadin tab of the highcharts-demo project properties panel to create superder mode code server launch configuration and modify the class path as instructed above. After starting the code server by running SuperDevMode launch as Java application, you can navigate to http://localhost:8080/highcharts-demo/?superdevmode. Now all code changes you do to your client side will get compiled as soon as you reload the web page. You can also access Java-sources and set breakpoints inside Chrome if you enable source maps from inspector settings. 

 
## Release notes

### Version 1.0-SNAPSHOT
- initial version of the Highcharts wrapper for Vaadin 7

## Roadmap

This component is developed as a hobby with no public roadmap or any guarantees of upcoming releases.
That said, the following features are planned for upcoming releases:
- ...

## Issue tracking

The issues for this add-on are tracked on its github.com page. All bug reports and feature requests are appreciated. 

## Contributions

Contributions are welcome, but there are no guarantees that they are accepted as such. Process for contributing is the following:
- Fork this project
- Create an issue to this project about the contribution (bug or feature) if there is no such issue about it already. Try to keep the scope minimal.
- Develop and test the fix or functionality carefully. Only include minimum amount of code needed to fix the issue.
- Refer to the fixed issue in commit
- Send a pull request for the original project
- Comment on the original issue that you have implemented a fix for it

## License & Author

Add-on is distributed under Apache License 2.0. For license terms, see LICENSE.txt.

Highcharts for Vaadin7 is written by Stefan Endrullis.

# Developer Guide

## Getting started

Here is a simple example on how to try out the add-on component:

<...>

For a more comprehensive example, see highcharts-demo/src/main/java/org/vaadin/highcharts/demo/DemoUI.java

## Features

### Feature A

<...>

### Feature B

<...>

### Feature C

<...>

## API

MyComponent JavaDoc is available online at <...>
