package com.mv.service;

import com.mv.model.DecryptRequest;
import com.mv.model.DecryptResponse;
import com.mv.model.EncryptRequest;
import com.mv.model.EncryptResponse;
import com.mv.model.RetrieveKeyResponse;

public interface CryptoService {

	RetrieveKeyResponse getKey();
	
	EncryptResponse encrypt(EncryptRequest request);
	
	DecryptResponse decrypt(DecryptRequest request);
}
