package com.mv.service.impl;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mv.config.CryptoConfig;
import com.mv.exception.CryptoServiceException;
import com.mv.model.DecryptRequest;
import com.mv.model.DecryptResponse;
import com.mv.model.EncryptRequest;
import com.mv.model.EncryptResponse;
import com.mv.model.RetrieveKeyResponse;
import com.mv.service.CryptoService;
import com.mv.util.CryptoUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CryptoServiceImpl implements CryptoService {

  @Autowired
  private CryptoConfig cryptoConfig;

  @Override
  public RetrieveKeyResponse getKey() {
    return RetrieveKeyResponse.builder().key(cryptoConfig.getEncryptionKey())
        .algorithm(cryptoConfig.getAlgorithm()).build();
  }

  @Override
  public EncryptResponse encrypt(EncryptRequest request) {

    String value = request.getValue();
    try {
      IvParameterSpec ivSpec = CryptoUtil.generateIv(CryptoUtil.decodeHex(cryptoConfig.getIv()));
      Cipher cipher = Cipher.getInstance(cryptoConfig.getAlgorithm());
      cipher.init(Cipher.ENCRYPT_MODE, CryptoUtil.decodeKey(cryptoConfig.getEncryptionKey()),
          ivSpec);

      byte[] encryptedBytes = cipher.doFinal(value.getBytes());

      String encryptedHex = CryptoUtil.encodeHex(encryptedBytes);

      return EncryptResponse.builder().encryptedValue(encryptedHex).build();

    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
      log.error("A cipher error occurred", e);
      throw new CryptoServiceException("cipherExceptionError", e.getMessage());
    }

  }

  @Override
  public DecryptResponse decrypt(DecryptRequest request) {
    String encryptedValue = request.getEncryptedValue();
    try {
      IvParameterSpec ivSpec = CryptoUtil.generateIv(CryptoUtil.decodeHex(cryptoConfig.getIv()));
      Cipher cipher = Cipher.getInstance(cryptoConfig.getAlgorithm());
      cipher.init(Cipher.DECRYPT_MODE, CryptoUtil.decodeKey(cryptoConfig.getEncryptionKey()),
          ivSpec);

      byte[] decryptedBytes = cipher.doFinal(CryptoUtil.decodeHex(encryptedValue));

      return DecryptResponse.builder().decryptedValue(new String(decryptedBytes)).build();

    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException
        | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
      log.error("A cipher error occurred", e);
      throw new CryptoServiceException("cipherExceptionError", e.getMessage());
    }
  }

}
