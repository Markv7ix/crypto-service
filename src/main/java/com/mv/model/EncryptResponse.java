package com.mv.model;

import lombok.Builder;
import lombok.Data;

@Data
/**
 * Encrypt response class.
 * 
 * @author 2220832
 *
 */
@Builder
public class EncryptResponse {

  /**
   * Encrypted value.
   */
  private String encryptedValue;
}
