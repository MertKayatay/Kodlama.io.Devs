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

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.CreateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.DeleteProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.UpdateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetByIdProgrammingTechnologiesResponse;

@RestController
@RequestMapping("/api/programmingtechnologies")
public class TechnologiesController {
	private IProgrammingLanguageTechnologyService programmingTechnologiesService;
	

	@Autowired
	public TechnologiesController(IProgrammingLanguageTechnologyService programmingTechnologiesService) {
		
		this.programmingTechnologiesService = programmingTechnologiesService;
	}

	@GetMapping("/getAll")
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll(){
		return programmingTechnologiesService.getAll();	
	}
	
	@GetMapping("/getbyıd/{id}")
	public GetByIdProgrammingTechnologiesResponse getById(@RequestParam int id) {
		return programmingTechnologiesService.getById(id);	
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateProgrammingTechnologiesReq createProgrammingTechnologiesReq) {
		programmingTechnologiesService.add(createProgrammingTechnologiesReq);
	}
	@DeleteMapping("/delete")
	public void delete(@RequestBody DeleteProgrammingTechnologiesReq deleteProgrammingTechnologiesReq) {
		programmingTechnologiesService.delete(deleteProgrammingTechnologiesReq);
	}
	@PostMapping("/update")
	public void update(@RequestBody UpdateProgrammingTechnologiesReq updateProgrammingTechnologiesReq) {
		programmingTechnologiesService.update(updateProgrammingTechnologiesReq);
	}

}
