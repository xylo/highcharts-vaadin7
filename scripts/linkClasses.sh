#!/bin/bash

cd `dirname $0`
. settings.conf
cd ..

# link webapp directory
ln -s highcharts-demo/target/$PROJECT_NAME-demo-$PROJECT_VERSION-SNAPSHOT tomcat-webapp

# link classes of add-on
cd "$PROJECT_NAME/target"
rm -Rf classes
ln -s ../../$PROJECT_NAME-demo/target/$PROJECT_NAME-demo-$PROJECT_VERSION-SNAPSHOT/WEB-INF/classes

cd ../..

# link classes of demo
cd "$PROJECT_NAME-demo/target"
rm -Rf classes
ln -s $PROJECT_NAME-demo-$PROJECT_VERSION-SNAPSHOT/WEB-INF/classes
