package ru.eshakin.schoolinfo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";


    @ExceptionHandler(value = BindException.class)
    public ModelAndView bindExceptionHandler(BindException ex) {
        StringBuilder sb = new StringBuilder();
        ex.getBindingResult().getAllErrors()
                .stream()
                .filter(FieldError.class::isInstance)
                .map(FieldError.class::cast)
                .forEach(fieldError ->
                        sb.append(fieldError.getField())
                                .append(" - ")
                                .append(fieldError.getDefaultMessage())
                                .append('\n')
                );
        return packToTheFront(sb.toString());
    }

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception ex) {

        System.err.println(ex);
        return packToTheFront(ex.getMessage());
    }

    private ModelAndView packToTheFront(String message) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", message);
        mav.setViewName(DEFAULT_ERROR_VIEW);
        log.warn(message);
        return mav;
    }


}