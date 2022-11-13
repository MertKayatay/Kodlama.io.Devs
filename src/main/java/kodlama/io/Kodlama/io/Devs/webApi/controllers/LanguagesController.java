package kodlama.io.Kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

@RestController 
@RequestMapping("/api/programminglanguages")
public class LanguagesController {
	private IProgrammingLanguageService programmingLanguageService;
    
	@Autowired
	public LanguagesController(IProgrammingLanguageService programmingLanguageService) {
		
		this.programmingLanguageService = programmingLanguageService;
	}
	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguagesResponse> getAll() {
		return programmingLanguageService.getAll();
	}
	
	@GetMapping("/getbyid/{id}")
	public GetByIdProgrammingLanguageResponse getById(@RequestParam int id) {
		return programmingLanguageService.getById(id);
	}
	
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingLanguageReq createProgrammingLanguageReq) {
		programmingLanguageService.add(createProgrammingLanguageReq);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UpdateProgrammingReq updateProgrammingLanguageReq) {
		programmingLanguageService.update(updateProgrammingLanguageReq);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingLanguageReq deleteProgrammingLanguageReq) {
		programmingLanguageService.delete(deleteProgrammingLanguageReq);
	}
	
	
	

}
