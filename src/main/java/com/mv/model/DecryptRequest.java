package com.mv.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Decrypt request class.
 * 
 * @author 2220832
 *
 */
@Data
public class DecryptRequest {

  /**
   * Encrypted value.
   */
  @NotNull
  private String encryptedValue;
}
