package sistema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sistema.entities.Cliente;
import sistema.repository.ClienteRepository;

@Controller
public class CadastroCliente {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/cadastrar")
    public String formularioCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastroClientes(@ModelAttribute Cliente cliente, Model model, RedirectAttributes redirectAttributes) {
        if (clienteRepository.findByLogin(cliente.getLogin()).isPresent()) {
            model.addAttribute("erro", "Este login já está em uso, escolha outro.");
            return "cadastrar";
        }

        try {
            cliente.setSenha(passwordEncoder.encode(cliente.getSenha()));
            clienteRepository.save(cliente);
            redirectAttributes.addFlashAttribute("ok", "Conta criada com sucesso!");
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("erro", "Não foi possível cadastrar, tente novamente.");
            return "cadastrar";
        }
    }
}
