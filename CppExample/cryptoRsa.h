#include <openssl/bio.h> /* BasicInput/Output streams */
#include <openssl/err.h> /* errors */
#include <openssl/ssl.h> /* core library */
#include <openssl/rsa.h>
#include <openssl/pem.h>
#include <iostream>
#include <stdio.h>
#include <string.h>
#include <string>

#define CRYPTO_RSA_KEY_LEN_4096 4096
#define CRYPTO_RSA_KEY_LEN_2048 2048
#define CRYPTO_RSA_KEY_LEN_1024 1024
#define CRYPTO_RSA_KEY_EXP      65535
#define CRYPTO_PRINT_ERROR fprintf(stderr, "[x] %s\n", strerror(errno))

class CryptoRSA{
private:
	  RSA *pRSA;
	  int keylen;

public:
  bool GenerateKeys(int key_length){
    SetKeyLength(key_length);
    pRSA = RSA_generate_key(GetKeyLength(), CRYPTO_RSA_KEY_EXP, NULL, NULL);
    if (RSA_check_key(pRSA) != 1){
      CRYPTO_PRINT_ERROR;
      return false;
    }
    return true;
  }

  void SetKeyLength(int key_length){
    keylen = key_length;
  }

  int GetKeyLength(){
    return keylen;
  }

  RSA *GetRSABlob(){
    return pRSA;
  }

  bool ReadPublicKeyBuffer(void *src, size_t src_size){
    FILE *fp = fmemopen(src, src_size, "rb");
    if (fp == NULL){
      CRYPTO_PRINT_ERROR;
      return false;
    }
    if (PEM_read_RSAPublicKey(fp, &pRSA, NULL, NULL) == NULL){
      CRYPTO_PRINT_ERROR;
      return false;
    }
    fclose(fp);
    return true;
  }



};
