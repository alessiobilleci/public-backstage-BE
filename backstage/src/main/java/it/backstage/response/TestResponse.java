package it.backstage.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import it.backstage.vo.TestVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestResponse extends BaseResponse{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TestVO vo;
	/**
	 * Gets the successful request response.
	 *
	 * @param response    the response
	 * @param description the description
	 * @param message     the message
	 * @return the successful request response
	 */
	public static ResponseEntity<Object> getSuccessfulRequestResponse(TestResponse response,
			String description, String message) {

		response.setCode(200);
		response.setDescription(description);
		response.setMessage(message);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
