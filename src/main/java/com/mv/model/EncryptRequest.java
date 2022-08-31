package com.mv.model;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Encrypt request class.
 * 
 * @author 2220832
 *
 */
@Data
public class EncryptRequest {

  /**
   * Value to encrypt.
   */
  @NotNull
  private String value;
}
