package it.backstage.response;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class BaseResponse.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The code. */
	private int code;

	/** The description. */
	private String description;

	/** The message. */
	private String message;

	/**
	 * Gets the successful request response.
	 *
	 * @param response    the response
	 * @param description the description
	 * @param message     the message
	 * @return the successful request response
	 */
	public static ResponseEntity<Object> getSuccessfulRequestResponse(BaseResponse response, String description,
			String message) {

		response.setCode(200);
		response.setDescription(description);
		response.setMessage(message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
