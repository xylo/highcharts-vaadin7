#!/bin/bash

cd `dirname $0`
. settings.conf
cd ..

cp -Rf highcharts/src/main/resources/* tomcat-webapp/WEB-INF/classes/
cp -Rf highcharts-demo/src/main/resources/* tomcat-webapp/WEB-INF/classes/

# copy content of webapp directory
#cp -Rf src/main/webapp/VAADIN/* tomcat-webapp/VAADIN/
