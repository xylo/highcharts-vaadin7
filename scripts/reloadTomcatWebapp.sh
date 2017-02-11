#!/bin/bash

cd `dirname $0`
. userSettings.conf
cd ..

cp -R target/classes/* target/testwebapp-export/WEB-INF/classes
cp -R target/test-classes/* target/testwebapp-export/WEB-INF/classes

permGen=$(curl "http://$TOMCAT_USERNAME:$TOMCAT_PASSWORD@localhost:8080/manager/status" 2>/dev/null | gawk -F "Perm Gen" '{print $2}'|gawk -F "(" '{print $2}'| gawk -F "%)" '{print $1}'| sed '/^\s*$/d')

if [ $permGen -gt 80 ]; then
	./restartTomcat.sh
	notify-send Tomcat 'Tomcat restarted!'
else
	curl --user "$TOMCAT_USERNAME:$TOMCAT_PASSWORD" "http://localhost:8080/manager/text/reload?path=/$APP_NAME" >/dev/null
	notify-send "$PROJECT_NAME" "reloaded: $permGen %"
fi
