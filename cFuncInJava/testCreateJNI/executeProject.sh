#!/bin/bash

echo <<EOF
This scipt generate the .o files associated with the cpp files and generate .so library(shared library), 
which can be used from java to call cpp functions
EOF

echo "Set enviromnent variable..."
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:"/home/jan/eclipse-java-workspace/srnProject/cFuncInJava"

echo "Compile java..."
javac -h . --module-path "/home/jan/openjfx-18.0.1_linux-x64_bin-sdk/javafx-sdk-18.0.1/lib/" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing start/JNIHello.java srnGui/Main.java buttonHandling/CreateAccount.java buttonHandling/UserPage.java

echo "Generate hello.o and .so library..."
g++ -c -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux hello.cpp -o hello.o
g++ -shared -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux start_JNIHello.cpp hello.o -o libjnihello.so
echo "Execute java..."
echo
echo <<EOF


EOF
java --module-path "/home/jan/openjfx-18.0.1_linux-x64_bin-sdk/javafx-sdk-18.0.1/lib/" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing start.JNIHello

echo <<EOF
-p "/home/jan/eclipse-java-workspace/srnProject/cFuncInJava" 
EOF
