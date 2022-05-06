#include "test_HelloJava.h"
#include <iostream>
#include <fstream>
#include <string>
#include "cryptoRsa.h"


using namespace std;

void entry();
string readFileIntoString(const string& path);


JNIEXPORT void JNICALL Java_test_HelloJava_helloBlub
(JNIEnv *, jclass){
	cout<<"Hello to Java from Cpp\n"<<endl;
	entry();
}

string readFileIntoString(const string& path) {
	ifstream input_file(path);
	if (!input_file.is_open()) {
		cerr << "Could not open the file - '"
				<< path << "'" << endl;
		exit(EXIT_FAILURE);
	}
	return string((std::istreambuf_iterator<char>(input_file)), std::istreambuf_iterator<char>());
}





void entry(){
	string filename("../CppExample/src/blablub.txt");
	string *file_contents = new string;

	*file_contents = readFileIntoString(filename);
	cout << "Text from file reading:" << endl;
	cout << *file_contents << endl;
	free(file_contents);

	CryptoRSA cryptoRsa;

	//cryptoRsa.SetKeyLength(1024);
	cryptoRsa.GenerateKeys(1024);
}




