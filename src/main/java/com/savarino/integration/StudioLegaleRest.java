package com.savarino.integration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.savarino.entities.Clienti;
import com.savarino.entities.Pratiche;
import com.savarino.repo.ClientiDAO;
import com.savarino.repo.PraticheDAO;
import com.savarino.services.StudioLegaleService;

@RestController
@RequestMapping("api")
public class StudioLegaleRest {

	@Autowired
	private StudioLegaleService studioLegaleService;
	
	@Autowired
	private ClientiDAO clientiDAO;
	
	@Autowired
	private PraticheDAO praticheDAO;

	@GetMapping("pratiche")
	public List<Pratiche> getPratiche() {
		return studioLegaleService.getAllPratiche();
	}
	@GetMapping("clienti")
	public List<Clienti>getClienti(){
		return studioLegaleService.getAllClinti();
	}
	@PostMapping(value = "addCliente",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE )
	public ResponseEntity<String>inserisciCliente(@ModelAttribute Clienti clienti){
		studioLegaleService.addCliente(clienti);
		return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(clienti.getId()).toString());
	}
	@PostMapping(value = "addPratica", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<String>inserisciPratica(@ModelAttribute Pratiche pratiche){
		studioLegaleService.addPratiche(pratiche);
		return ResponseEntity.status(HttpStatus.CREATED).body(Integer.valueOf(pratiche.getId()).toString());
	}
	@PostMapping("eliminaCliente")
	public void eliminaCliente(int id) {
		clientiDAO.deleteById(id);
		
	}
	@PostMapping("eliminaPratica")
	public void eliminaOrdine(int id) {
		praticheDAO.deleteById(id);
	
	}
	
	
}
