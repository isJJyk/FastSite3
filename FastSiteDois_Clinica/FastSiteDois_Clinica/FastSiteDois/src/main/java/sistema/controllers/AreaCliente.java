package sistema.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sistema.repository.ClienteRepository;
@Controller
public class AreaCliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/home")
    public String home(HttpSession session) {
        if (!logado(session)) {
            return "redirect:/login";
        }
        return "home";
    }

    @GetMapping("/clientes")
    public String listaClientes(HttpSession session, Model model) {
        if (!logado(session)) {
            return "redirect:/login";
        }
        model.addAttribute("clientes", clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "id")));
        return "clientes";
    }

    private boolean logado(HttpSession session) {
        return session.getAttribute(LoginCliente.SESSAO_CLIENTE) != null;
    }
}
