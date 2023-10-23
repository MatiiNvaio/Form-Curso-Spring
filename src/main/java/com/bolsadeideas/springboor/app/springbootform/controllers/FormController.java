package com.bolsadeideas.springboor.app.springbootform.controllers;

import com.bolsadeideas.springboor.app.springbootform.editors.NombreMayusEditor;
import com.bolsadeideas.springboor.app.springbootform.editors.PaisPropertyEditor;
import com.bolsadeideas.springboor.app.springbootform.editors.RolePropertyEditor;
import com.bolsadeideas.springboor.app.springbootform.models.domain.Pais;
import com.bolsadeideas.springboor.app.springbootform.models.domain.Role;
import com.bolsadeideas.springboor.app.springbootform.models.domain.Usuario;
import com.bolsadeideas.springboor.app.springbootform.services.PaisService;
import com.bolsadeideas.springboor.app.springbootform.services.RoleService;
import com.bolsadeideas.springboor.app.springbootform.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
// sirve para mantener datos que no van a estár en el formulario (en este caso identificador)
// y que no se eliminen cuando se recarg el form
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioValidador validador;

    @Autowired
    private PaisService paisService;

    @Autowired
    private PaisPropertyEditor paisEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolePropertyEditor roleEditor;

    // esto lo que hace es validar pero de forma transparente
    @InitBinder
    public void initBinder(WebDataBinder binder){

        // agrega validaciones a la clase UsuarioValidador
        binder.addValidators(validador);
        // crea un objeto que determina el formato de la fecha
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        date.setLenient(true);

        binder.registerCustomEditor(Date.class, new CustomDateEditor(date, true));
        binder.registerCustomEditor(String.class, new NombreMayusEditor());
        binder.registerCustomEditor(Pais.class, "pais",paisEditor);
        binder.registerCustomEditor(Role.class, "roles",roleEditor);
    }

    @ModelAttribute("genero")
    public List<String> genero(){
        return Arrays.asList(
                "Hombre", "Mujer");
    }

    @ModelAttribute("listaRolesString")
    public List<String> listaRolesString(){

        List<String> roles = new ArrayList<>();
        roles.add("ROLE_ADIMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");
        return roles;
    }

    @ModelAttribute("listaRolesMap")
    public Map<String, String> listaRolesMap(){

        Map<String, String> roles = new HashMap<>();
        roles.put("ROLE_ADIMIN", "Administrador");
        roles.put("ROLE_USER", "Usuario");
        roles.put("ROLE_MODERATOR", "Moderador");

        return roles;
    }

    @ModelAttribute("listaRoles")
    public List<Role> listaRoles(){
        return roleService.listar();
    }

    // creamos un método que retorna una lista de paises para elegir
    // con @ModelAttribute pasamos a la vista
    @ModelAttribute("paises")
    public List<String> paises(){

        return Arrays.asList(
                "Argentina",
                "España",
                "Chile",
                "Mexico",
                "Peru",
                "Colombia",
                "Venezuela"
        );
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises(){

        return paisService.listar();
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap(){

        Map<String, String> paises = new HashMap<>();
        paises.put("AR", "Argentina");
        paises.put("ES", "España");
        paises.put("CL", "Chile");
        paises.put("MX", "Mexico");
        paises.put("PE", "Peru");
        paises.put("CO", "Colombia");
        paises.put("VE", "Venezuela");

        return paises;
    }

    @GetMapping("/form")
    public String form(Model model){
        model.addAttribute("titulo", "Formulario usuarios");
        Usuario usuario = new Usuario();

        // llena automiticamente el campo identificador en el form
        usuario.setIdentificador("12.453.422-L");
        usuario.setValorSecreto("Algún valor secreto ****");

        // marca un checkbox de manera automatica
        usuario.setHabilitar(true);

        // deja un pais puesto por defecto en el select
        usuario.setPais(new Pais(1, "AR", "Argentina"));

        // deja un chackbox marcado por defecto, en este caso usuario
        usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult resultado, Model model){

//        validador.validate(usuario, resultado);

        // crea los mensajes de error manualmente
        if(resultado.hasErrors()){
            model.addAttribute("titulo", "Resultado del formulario");
            return "form";
        }
        return "redirect:/resultado";
    }

    // este metodo sirve para que cuando se muestren los datos del form y se recargue la pagina
    // no se dupliquen los datos en caso de trabjar con bases
    @GetMapping("/resultado")
    public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model, SessionStatus status){

        if(usuario == null){
            return "redirect:/form";
        }

        model.addAttribute("titulo", "Resultado del formulario");

        status.setComplete();
        return "ver";
    }
}
