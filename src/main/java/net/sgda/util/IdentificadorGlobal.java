
package net.sgda.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class IdentificadorGlobal {
    @ExceptionHandler(MultipartException.class)
    public String handleMultipart(MultipartException e,RedirectAttributes attributes){
        attributes.addFlashAttribute("msg", e.getCause().getMessage());
        return "redirect:/usuario/crear";
    }
}
