
public class JNIHello {
	static {
		//System.load("/home/philipp/Documents/srnProject/srnGui/src/cFunctions/libjnihello");
		System.loadLibrary("jnihello");
	}
	public static void main(String []args) {
		System.out.println("Hallo");
		helloJNI();
	}
	
	public static native void helloJNI();

}


//g++ -shared -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux JNIHello.cpp -o libjnihello.so

//export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/home/philipp/Documents/srnProject/srnGui/src/cFunctions/libjnihello.so


//1
//g++ -c -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux hello.cpp -o hello.o


//2
//g++ -shared -O2 -Wall -fPIC -I /usr/lib/jvm/java-11-openjdk-amd64/include -I /usr/lib/jvm/java-11-openjdk-amd64/include/linux cFunctions_JNIHello.cpp hello.o -o libjnihello.so
