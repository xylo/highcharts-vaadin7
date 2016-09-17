#!/bin/bash

cd `dirname $0`
. userSettings.conf || exit 1
cd ..

mkdir -p target/testwebapp-export/META-INF
mkdir -p target/testwebapp-export/VAADIN
mkdir -p target/testwebapp-export/WEB-INF/classes
mkdir -p target/testwebapp-export/WEB-INF/lib

cat <<END >target/testwebapp-export/META-INF/context.xml
<?xml version="1.0" encoding="UTF-8"?>
<Context antiJARLocking="true" path="/highcharts-vaadin7"/>
END

# copy widgetset
cp -R target/testwebapp/VAADIN/widgetsets target/testwebapp-export/VAADIN/

# copy libs
mvn -DoutputDirectory=target/testwebapp-export/WEB-INF/lib \
    -DexcludeGroupIds=org.seleniumhq.selenium,org.eclipse.jetty \
    -DexcludeArtifactIds=vaadin-client-compiler,vaadin-client,gwt-dev,gwt-user \
     dependency:copy-dependencies

# copy classes
cp -R target/classes/* target/testwebapp-export/WEB-INF/classes/
cp -R target/test-classes/* target/testwebapp-export/WEB-INF/classes/

# build war
cd target/testwebapp-export
jar cf ../$APP_NAME.war *
