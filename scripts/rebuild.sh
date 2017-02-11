#!/bin/bash

cd `dirname $0`
. generalSettings.conf
cd ..

PROJECT_VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:2.1.1:evaluate -Dexpression=project.version | grep -v '\[' | grep -v D)
WEB_DIR_PATH=target/$PROJECT_NAME-$PROJECT_VERSION

mvn -P demo-war clean package

# link webapp directory
rm tomcat-webapp >/dev/null 2>&1
ln -s $WEB_DIR_PATH tomcat-webapp

cp -R target/classes/* tomcat-webapp/WEB-INF/classes/
cp -R target/test-classes/* tomcat-webapp/WEB-INF/classes/

#scripts/linkClasses.sh
#scripts/copyResources.sh
