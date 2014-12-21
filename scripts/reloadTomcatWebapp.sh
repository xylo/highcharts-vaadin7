#!/bin/bash

cd `dirname $0`
. settings.conf

curl --user "$TOMCAT_USERNAME:$TOMCAT_PASSWORD" "$TOMCAT_MANAGER_URL/reload?path=/$WEBAPP_NAME" >/dev/null

if [[ "$1" == "" ]]; then
	curl "$APP_URL" >/dev/null
else
	curl "$1" >/dev/null
fi

notify-send "$PROJECT_NAME" reloaded
