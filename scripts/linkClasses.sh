#!/bin/bash

cd `dirname $0`
. generalSettings.conf
cd ..

WEB_DIR_PATH=$DEMO_PROJECT_NAME/target/$DEMO_PROJECT_NAME-$DEMO_PROJECT_VERSION

# link webapp directory
ln -s $WEB_DIR_PATH tomcat-webapp

# link classes of add-on
cd "$PROJECT_NAME/target"
rm -Rf classes
ln -s ../../$WEB_DIR_PATH/WEB-INF/classes

cd ../..

# link classes of demo
cd "$DEMO_PROJECT_NAME/target"
rm -Rf classes
ln -s $DEMO_PROJECT_NAME-$DEMO_PROJECT_VERSION/WEB-INF/classes
