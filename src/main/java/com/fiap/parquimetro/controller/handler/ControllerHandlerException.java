package com.fiap.parquimetro.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(RuntimeException.class)
    public ProblemDetail handleException(RuntimeException e) {
        var problem = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        problem.setTitle("Nao foi possivel executar a operacao solicitaca");
        problem.setDetail(e.getMessage());

        return problem;
    }
}
