package com.example.demo.contoller;
import java.time.LocalDateTime;
import com.example.demo.Exception.AtmHandlerException;
import com.example.demo.dto.ErrorInfoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
public class AtmExceptionHandler {

	@ExceptionHandler({AtmHandlerException.class})
	@ResponseBody
	public ResponseEntity<ErrorInfoDTO> applicationException(AtmHandlerException e) {
		ErrorInfoDTO error = new ErrorInfoDTO();
		error.setCode(e.getStatus());
		error.setMessage(e.getMessage());
		error.setTimestamp(LocalDateTime.now());
		return ResponseEntity
				.status(e.getStatus())
				.body(error);
	}


}
