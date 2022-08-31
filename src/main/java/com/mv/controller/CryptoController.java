package com.mv.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.config.CryptoConfig;
import com.mv.model.DecryptRequest;
import com.mv.model.DecryptResponse;
import com.mv.model.EncryptRequest;
import com.mv.model.EncryptResponse;
import com.mv.model.RetrieveKeyResponse;
import com.mv.service.CryptoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class CryptoController {

	/**
	 * Crypto service instance.
	 */
	@Autowired
	private CryptoConfig cryptoConfig;
	
	/**
	 * Crypto service instance.
	 */
	@Autowired
	private CryptoService cryptoService;

	/**
	 * Retrieve key controller method.
	 * 
	 * @return
	 */
	@GetMapping(path="${crypto-service.config.path.retrieveKey.url}")
	public ResponseEntity<RetrieveKeyResponse> retrieveKey() {

		log.debug("Retrieve key request");
		RetrieveKeyResponse response = cryptoService.getKey();

		log.debug("Retrieve key response: {}", response);

		return ResponseEntity.ok(response);
	}

	/**
	 * 
	 * @return
	 */
	@PostMapping(path="${crypto-service.config.path.encryption.url}")
	public ResponseEntity<EncryptResponse> encrypt(@Valid @RequestBody EncryptRequest request) {

		log.debug("Encrypt request: {}", request);

		EncryptResponse response = cryptoService.encrypt(request);

		log.debug("Encrypt response: {}", response);

		return ResponseEntity.ok(response);
	}

	/**
	 * Decryption controller method.
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(path="${crypto-service.config.path.decryption.url}")
	public ResponseEntity<DecryptResponse> decrypt(@Valid @RequestBody DecryptRequest request) {

		log.debug("Decrypt request: {}", request);

		DecryptResponse response = cryptoService.decrypt(request);

		log.debug("Decrypt response: {}", response);

		return ResponseEntity.ok(response);
	}

}
