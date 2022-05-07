#!/bin/bash

echo <<EOF
This scipt generate the .o files associated with the cpp files and generate .so library(shared library), 
which can be used from java to call cpp functions
EOF

echo "Generate hello.o and .so library"
g++ -c -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux hello.cpp -o hello.o
g++ -shared -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux JNIHello.cpp hello.o -o libjnihello.so
echo "Finished with generating .o files and .so"
echo "Execute java:"
echo
java JNIHello
