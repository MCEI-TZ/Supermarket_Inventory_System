package com.mceit_z.Inventory_System.config.exceptions;

import com.nimbusds.jose.JOSEException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.time.Instant;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleEntityNotFoundException(EntityNotFoundException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                ex.getMessage(),
                "The requested entity was not found",
                "NOT_FOUND",
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorDetails> handleBadCredentialsException(BadCredentialsException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "Invalid credentials provided",
                ex.getMessage(),
                "BAD_CREDENTIALS",
                HttpStatus.UNAUTHORIZED.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGeneralException(Exception ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An unexpected error occurred",
                ex.getMessage(),
                "INTERNAL_SERVER_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JOSEException.class)
    public ResponseEntity<ErrorDetails> handleJoseException(JOSEException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An error occurred while processing the JWT",
                ex.getMessage(),
                "JWT_PROCESSING_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> handleRuntimeException(RuntimeException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "A runtime exception occurred",
                ex.getMessage(),
                "RUNTIME_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorDetails> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An illegal argument was provided",
                ex.getMessage(),
                "ILLEGAL_ARGUMENT",
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorDetails> handleNullPointerException(NullPointerException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "A null pointer exception occurred",
                ex.getMessage(),
                "NULL_POINTER",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorDetails> handleUnsupportedOperationException(UnsupportedOperationException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An unsupported operation was attempted",
                ex.getMessage(),
                "UNSUPPORTED_OPERATION",
                HttpStatus.NOT_IMPLEMENTED.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ErrorDetails> handleIllegalStateException(IllegalStateException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An illegal state was encountered",
                ex.getMessage(),
                "ILLEGAL_STATE",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity<ErrorDetails> handleSecurityException(SecurityException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "Security violation occurred",
                ex.getMessage(),
                "SECURITY_VIOLATION",
                HttpStatus.FORBIDDEN.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handleAccessDeniedException(AccessDeniedException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "Access denied",
                ex.getMessage(),
                "ACCESS_DENIED",
                HttpStatus.FORBIDDEN.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<ErrorDetails> handleSQLException(SQLException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "A database error occurred",
                ex.getMessage(),
                "SQL_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ErrorDetails> handleArithmeticException(ArithmeticException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "An arithmetic error occurred",
                ex.getMessage(),
                "ARITHMETIC_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClassCastException.class)
    public ResponseEntity<ErrorDetails> handleClassCastException(ClassCastException ex) {
        ErrorDetails errorDetails = new ErrorDetails(
                Instant.now(),
                "A class cast exception occurred",
                ex.getMessage(),
                "CLASS_CAST_ERROR",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
