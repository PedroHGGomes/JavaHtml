package webapp.demo.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import webapp.demo.model.Ovni;
import webapp.demo.repository.OvniRepository;

@Controller
public class OvniController {

    private final OvniRepository ovniRepository;

    public OvniController(OvniRepository ovniRepository) {
        this.ovniRepository = ovniRepository;
    }

    @GetMapping("/")
    public String index(@RequestParam(name="q", required=false) String q, Model model) {
        var lista = (q == null || q.isBlank())
                ? ovniRepository.findAll()
                : ovniRepository.findByLocalContainingIgnoreCaseOrDescricaoContainingIgnoreCase(q, q);
        model.addAttribute("ovnis", lista);
        model.addAttribute("q", q);
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(@RequestParam(required = false) Long id, Model model) {
        Ovni ovni = (id != null) ? ovniRepository.findById(id).orElse(new Ovni()) : new Ovni();
        model.addAttribute("ovni", ovni); // <- garante th:object
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvar(@Valid @ModelAttribute("ovni") Ovni ovni, BindingResult br, Model model) {
        if (br.hasErrors()) {
            return "cadastro"; // volta pro form mostrando erros
        }
        ovniRepository.save(ovni);
        return "redirect:/";
    }
}

