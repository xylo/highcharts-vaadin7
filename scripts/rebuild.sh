#!/bin/bash

cd `dirname $0`
. generalSettings.conf
cd ..

mvn clean package

rm tomcat-webapp >/dev/null 2>&1

scripts/linkClasses.sh
scripts/copyResources.sh
