package com.mv.model;

import lombok.Builder;
import lombok.Data;

@Data
/**
 * Retrieve key response class.
 * 
 * @author 2220832
 *
 */
@Builder
public class RetrieveKeyResponse {

  /**
   * Encoded encryption key.
   */
  private String key;

  /**
   * Algorithm string.
   */
  private String algorithm;
}
