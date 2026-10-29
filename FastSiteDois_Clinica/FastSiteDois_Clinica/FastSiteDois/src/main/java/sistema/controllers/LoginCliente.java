package sistema.controllers;

import jakarta.servlet.http.HttpSession;
import sistema.entities.Cliente;
import sistema.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginCliente {

    public static final String SESSAO_CLIENTE = "clienteLogadoId";

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String paginaLogin(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "login";
    }

    @PostMapping("/login")
    public String loginCliente(@ModelAttribute("cliente") Cliente cliente, Model model, HttpSession session) {
        Optional<Cliente> clienteEncontrado = clienteRepository.findByLogin(cliente.getLogin());

        if (clienteEncontrado.isPresent()
                && passwordEncoder.matches(cliente.getSenha(), clienteEncontrado.get().getSenha())) {
            session.setAttribute(SESSAO_CLIENTE, clienteEncontrado.get().getId());
            return "redirect:/home";
        }

        model.addAttribute("erro", "Usuário ou Senha incorretos, tente novamente");
        return "login";
    }
}
