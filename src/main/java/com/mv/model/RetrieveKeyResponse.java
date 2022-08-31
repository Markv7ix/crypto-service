package com.mv.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetrieveKeyResponse {
	
	private String key;
	
	private String algorithm;
}
