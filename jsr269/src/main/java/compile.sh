#!/usr/bin/env bash

if [ -d classes ]; then
    rm -rf classes;
fi
mkdir classes

javac -cp $JAVA_HOME/lib/tools.jar cn/puhy/jsr269/Getter* -d classes/

javac -cp classes -d classes -processor cn.puhy.jsr269.GetterProcessor cn/puhy/jsr269/TestGetter.java

javap -p classes cn/puhy/jsr269/TestGetter.class

java -cp classes cn.puhy.jsr269.TestGetter
