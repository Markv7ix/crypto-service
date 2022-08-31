package com.mv.service;

import com.mv.model.DecryptRequest;
import com.mv.model.DecryptResponse;
import com.mv.model.EncryptRequest;
import com.mv.model.EncryptResponse;
import com.mv.model.RetrieveKeyResponse;

/**
 * Crypto service definition interface.
 * 
 * @author 2220832
 *
 */
public interface CryptoService {

  /**
   * Retrieves configured key.
   * 
   * @return RetrieveKeyResponse object
   */
  RetrieveKeyResponse retrieveKey();

  /**
   * Encrypts a given value.
   * 
   * @param request Contains value to encrypt
   * @return EncryptResponse object
   */
  EncryptResponse encrypt(EncryptRequest request);

  /**
   * Decrypts a given cryptogram encrypted with {@link com.mv.CryptoService#encrypt(EncryptRequest)}
   * method.
   * 
   * @param request
   * @return
   */
  DecryptResponse decrypt(DecryptRequest request);
}
