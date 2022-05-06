package test;

public class HelloJava {
	


	public static void main(String[] args) {
		System.out.println("JNIHello");
		helloBlub();
	}
	public static native void helloBlub();
	
	static {
		//TODO: This should work -> find solution/ask competent people
		//System.loadLibrary("LibJni");
		
		//Insert your absolute path to shared library, loadLibrary is not working correctly, because
		//system can not find lib from enviromnent variable, whether it is set
		//with LD_LIBRARY_PATH
		System.load("/home/jan/eclipse-java-workspace/srnProject/CppExample/Debug/libCppExample");
	}
}
