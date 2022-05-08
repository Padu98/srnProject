#include "start_JNIHello.h"
#include "hello.h"

int main(){}

JNIEXPORT void JNICALL Java_start_JNIHello_helloJNI(JNIEnv *, jclass){
  hellojni(); }

