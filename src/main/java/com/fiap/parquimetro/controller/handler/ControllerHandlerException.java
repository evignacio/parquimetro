package com.fiap.parquimetro.controller.handler;

import com.fiap.parquimetro.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(ApplicationException.class)
    public ProblemDetail handleException(ApplicationException ex) {
        var problem = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        problem.setTitle("Nao foi possivel executar a operacao solicitaca");
        problem.setDetail(ex.getMessage());

        return problem;
    }
}
