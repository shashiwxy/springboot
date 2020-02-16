package com.mindtree.benchshoppingcart.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class PrettyFormatJSON {

	public static String getPrettyJSON(final Object obj) {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

		try {
			return ShoppingCartConstants.PRE_OPEN + mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj)
					+ ShoppingCartConstants.PRE_CLOSE;

		} catch (JsonProcessingException e) {
			return obj.toString();
		}
	}
}
