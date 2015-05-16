#!/bin/bash

cd `dirname $0`
. generalSettings.conf
cd ..

WEB_DIR_PATH=$DEMO_PROJECT_NAME/target/$DEMO_PROJECT_NAME-$DEMO_PROJECT_VERSION

cp -Rf $PROJECT_NAME/src/main/resources/* $WEB_DIR_PATH/WEB-INF/classes/
cp -Rf $DEMO_PROJECT_NAME/src/main/resources/* $WEB_DIR_PATH/WEB-INF/classes/
cp -Rf $DEMO_PROJECT_NAME/src/main/webapp/* $WEB_DIR_PATH/

# copy content of webapp directory
#cp -Rf src/main/webapp/VAADIN/* $WEB_DIR_PATH/VAADIN/
