#include "JNIHello.h"
#include "hello.h"

int main(){}

JNIEXPORT void JNICALL Java_JNIHello_helloJNI(JNIEnv *, jclass){
  hellojni(); }

