package com.mv.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EncryptResponse {

	private String encryptedValue;
}
