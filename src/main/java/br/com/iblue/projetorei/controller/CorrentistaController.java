package br.com.iblue.projetorei.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.iblue.projetorei.entity.Correntista;
import br.com.iblue.projetorei.repository.CorrentistaRepository;
import br.com.iblue.projetorei.repository.MovimentacaoRepository;

@ResponseBody
@RestController
@RequestMapping("/api")
public class CorrentistaController {

	@Autowired
	private CorrentistaRepository cdao;
	
	@Autowired
	private MovimentacaoRepository mdao;
	
	@GetMapping("/correntista/{id}")
	public ResponseEntity<?> findByCode(@PathVariable ("id") Long id){
		try {
			Correntista co = cdao.findById(id).get();
			return ResponseEntity.status(200).body(co);
		} catch (Exception ex) {
		String msg =  "Error: " + ex.getMessage();
		return ResponseEntity.status(500).body(msg);
		}
	}
	
	@GetMapping("/correntistas")
	public List<Correntista> findbycode(){
		return cdao.findAll();
	}
}