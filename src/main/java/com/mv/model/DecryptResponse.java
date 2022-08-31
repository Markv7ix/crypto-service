package com.mv.model;

import lombok.Builder;
import lombok.Data;

@Data
/**
 * Decrypt response class
 * 
 * @author 2220832
 *
 */
@Builder
public class DecryptResponse {

  /**
   * Decrypted value.
   */
  private String decryptedValue;
}
