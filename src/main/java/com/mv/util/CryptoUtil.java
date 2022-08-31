package com.mv.util;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import com.mv.constants.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CryptoUtil {

  public static String encodeBase64Url(String value) {
    Encoder encoder = Base64.getUrlEncoder();
    return new String(encoder.encode(value.getBytes()));
  }

  public static byte[] encodeBase64Url(byte[] value) {
    Encoder encoder = Base64.getUrlEncoder();
    return encoder.encode(value);
  }

  public static String decodeBase64Url(String value) {
    Decoder decoder = Base64.getUrlDecoder();
    return new String(decoder.decode(value.getBytes()));
  }

  public static byte[] decodeBase64Url(byte[] value) {
    Decoder decoder = Base64.getUrlDecoder();
    return decoder.decode(value);
  }

  public static Key generateAesKey(String alg, int size) throws NoSuchAlgorithmException {
    KeyGenerator keyGen = KeyGenerator.getInstance(alg);
    keyGen.init(size);
    return keyGen.generateKey();
  }

  public static IvParameterSpec generateIv() {
    byte[] randArray = new byte[16];
    new SecureRandom().nextBytes(randArray);
    log.info("Random array: {}, random hex: {}", randArray, encodeHex(randArray));
    return generateIv(randArray);
  }
  
  public static IvParameterSpec generateIv(byte[] iv) {
    return new IvParameterSpec(iv);
  }

  public static Key decodeKey(String encodedKey) {

    byte[] decodedKey = decodeHex(encodedKey);
    return new SecretKeySpec(decodedKey, Constants.AES);
  }

  public static String encodeHex(byte[] value) {
    return Hex.encodeHexString(value);
  }

  public static byte[] decodeHex(String value) {
    try {
      return Hex.decodeHex(value);
    } catch (DecoderException e) {
      log.error("Hex decode error", e);
    }
    return null;
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String message = "This is a test message";
    String encodedMessage = encodeBase64Url(message);
    log.info("Input: {}  Encoded: {}", message, encodedMessage);

    log.info("Input: {}  Decoded: {}", encodedMessage, decodeBase64Url(encodedMessage));

    byte[] key = generateAesKey("AES", 256).getEncoded();
    log.info("Generated key: {}", key);
    String encodedKey = encodeHex(key);
    log.info("Encoded Key: {}", encodedKey);
    log.info("Decoded key: {}", decodeHex(encodedKey));

    generateIv();
  }

}
