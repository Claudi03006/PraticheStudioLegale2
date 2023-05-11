package com.savarino.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savarino.entities.Clienti;
import com.savarino.entities.Pratiche;
import com.savarino.repo.ClientiDAO;
import com.savarino.repo.PraticheDAO;

@Service
public class StudioLegaleServiceImpl implements StudioLegaleService {
	
	@Autowired
	private PraticheDAO praticheDAO;
	@Autowired
	private ClientiDAO clientiDAO;

	@Override
	public List<Pratiche> getAllPratiche() {
		// TODO Auto-generated method stub
		return praticheDAO.findAll();
	}

	@Override
	public List<Clienti> getAllClinti() {
		// TODO Auto-generated method stub
		return clientiDAO.findAll();
	}

	@Override
	public void addCliente(Clienti c) {
		// TODO Auto-generated method stub
		clientiDAO.save(c);
	}

	@Override
	public void addPratiche(Pratiche p) {
		// TODO Auto-generated method stub
		praticheDAO.save(p);
	}

}
