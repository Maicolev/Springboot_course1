package com.test.carCenter.controllers;

import com.test.carCenter.models.entity.Mecanico;
import com.test.carCenter.models.entity.MecanicosHorasTemp;
import com.test.carCenter.models.service.IMecanicoService;
import com.test.carCenter.models.resultSetExtractor.IMecanicoResultSetExtractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import javax.validation.Valid;
import java.util.*;

@Controller
@SessionAttributes("Mecanico")
public class MecanicoController
{
    @Autowired
    private IMecanicoService mecanicoService;

    @Autowired
    private IMecanicoResultSetExtractor mecanicoResultSetExtractor;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public String listar(Model model) {
        model.addAttribute("titulo", "Listado de mecanicos");
        model.addAttribute("mecanicos", mecanicoService.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form")
    public String spCrearMecanico(Map<String, Object> model) {

        Mecanico mecanico = new Mecanico();
        model.put("mecanico", mecanico);
        model.put("titulo", "Formulario de Mecanico");
        return "form";
    }

    @RequestMapping(value="/form/{documento}")
    public String editar(@PathVariable(value="documento") Long documento, Map<String, Object> model) {

        Mecanico mecanico = null;

        if(documento > 0) {
            mecanico = mecanicoService.findOne(documento);
        } else {
            return "redirect:/listar";
        }
        model.put("mecanico", mecanico);
        model.put("titulo", "Editar Mecanico");
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String  SpGuardarMecanico(@Valid Mecanico mecanico, BindingResult result, Model model, SessionStatus status)
    {
        if(result.hasErrors()) {
            model.addAttribute("titulo", "Formulario de mecanico");
            return "form";
        }

        //service
        //mecanicoService.save(mecanico);
        mecanicoResultSetExtractor.spCrearEditarMecanico(mecanico.getTipoDocumento(),mecanico.getDocumento(),mecanico.getPrimerNombre(),mecanico.getSegundoNombre(),mecanico.getPrimerApellido(),mecanico.getSegundoApellido(),mecanico.getCelular(),mecanico.getDireccion(),mecanico.getEmail(),mecanico.getEstado());
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value="/eliminar/{documento}")
    public String SpEliminar(@PathVariable(value="documento") Long documento, Model model)
    {
        if(documento > 0)
        {
            //service
            //mecanicoService.delete(documento);
            try
            {
                if(mecanicoService.findOne(documento) != null) {mecanicoResultSetExtractor.spEliminarMecanico(documento);}
            }
            catch (Exception e) {}
        }
        return "redirect:/listar";
    }

    @RequestMapping(value="/listarPrioridades")
    public String SpListarMecanicosPorPrioridades(Model model)
    {
        List<MecanicosHorasTemp> resultadoMecanicosHoras = mecanicoResultSetExtractor.darMecanicosPorPrioridades();
        List<Mecanico> mecanicos = new ArrayList<>();

       for (int i=0; i<resultadoMecanicosHoras.size();i++)
       {
           mecanicos.add(mecanicoService.findOne(resultadoMecanicosHoras.get(i).getDocumento()));
       }
        model.addAttribute("titulo", "Lista de mecanicos disponibles priorizados por menor carga de trabajo");
        model.addAttribute("mecanicosPriorizadosHoras", mecanicos);
        model.addAttribute("mecanicosPriorizadosHorasConHoras", resultadoMecanicosHoras);
        return "listarPrioridades";
    }

}

