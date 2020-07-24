package ru.zgys.telepresencedemo.web

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus.I_AM_A_TEAPOT
import org.springframework.http.HttpStatus.OK
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.zgys.telepresencedemo.service.UserService
import javax.servlet.http.HttpServletRequest

@RestController
class RootEndpoint(private val userService: UserService) {
    companion object {
        private val log = LoggerFactory.getLogger(RootEndpoint::class.java)
    }
    @GetMapping
    @ResponseStatus(OK)
    fun hello(servletRequest: HttpServletRequest) {
        val userHost = servletRequest.remoteHost ?: "Unknown"
        userService.collectHost(userHost)
    }

    @ExceptionHandler(RuntimeException::class)
    fun handleRuntime(ex: RuntimeException): ResponseEntity<*> {
        log.warn("Exception handled", ex)
        return ResponseEntity.status(I_AM_A_TEAPOT).body(ex.message)
    }
}