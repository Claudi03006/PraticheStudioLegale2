package com.savarino.services;

import java.util.List;

import com.savarino.entities.Clienti;
import com.savarino.entities.Pratiche;

public interface StudioLegaleService {
	List<Pratiche>getAllPratiche();
	List<Clienti>getAllClinti();
	void addCliente(Clienti c);
	void addPratiche(Pratiche p);
	

}
