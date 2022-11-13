package kodlama.io.Kodlama.io.Devs.business.concretes;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageTechnologyService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.CreateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.DeleteProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.UpdateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetByIdProgrammingTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologiesRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingTechnology;


@Service
public class ProgrammingLanguageTechnologyManager implements IProgrammingLanguageTechnologyService {
	private ProgrammingTechnologiesRepository _programmingTechnologiesRepo;
	private ProgrammingLanguageRepository _programmingLanguageRepo;
	
	@Autowired
	public ProgrammingLanguageTechnologyManager(ProgrammingTechnologiesRepository programmingTechnologyRepository, ProgrammingLanguageRepository programmingLanguageRepository) {
		_programmingLanguageRepo = programmingLanguageRepository;
		_programmingTechnologiesRepo = programmingTechnologyRepository;
	}
	
	
	
	
	@Override
	public List<GetAllProgrammingLanguageTechnologiesResponse> getAll() {
		List<ProgrammingTechnology> programmingTechnologies = _programmingTechnologiesRepo.findAll();
		List<GetAllProgrammingLanguageTechnologiesResponse> programmingTechnologiesResponse = new ArrayList<>();
		
		for(ProgrammingTechnology programmingTechnology : programmingTechnologies ) {
			GetAllProgrammingLanguageTechnologiesResponse responseItem = new GetAllProgrammingLanguageTechnologiesResponse();
			responseItem.setId(programmingTechnology.getId());
			responseItem.setName(programmingTechnology.getName());
			responseItem.setProgrammingLanguageName(programmingTechnology.getProgrammingLanguage().getName());
			programmingTechnologiesResponse.add(responseItem);
			
		}
		return programmingTechnologiesResponse;
		
		
	}
	@Override
	public GetByIdProgrammingTechnologiesResponse getById(int id) {
		ProgrammingTechnology programmingTechnologies = _programmingTechnologiesRepo.findById(id).get();
		GetByIdProgrammingTechnologiesResponse responseItem =new GetByIdProgrammingTechnologiesResponse();
		responseItem.setId(programmingTechnologies.getId());
		responseItem.setName(programmingTechnologies.getName());
		responseItem.setPrgorammingLanguageName(programmingTechnologies.getProgrammingLanguage().getName());
		
		
		return responseItem;
	}
	@Override
	public void add(CreateProgrammingTechnologiesReq createProgrammingTechnologiesRequest) {
		ProgrammingTechnology programmingTechnology =new ProgrammingTechnology();
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepo.findById(createProgrammingTechnologiesRequest.getProgrammingLanguageId()).get();
		programmingTechnology.setName(createProgrammingTechnologiesRequest.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		
		_programmingTechnologiesRepo.save(programmingTechnology);
		
	}
	@Override
	public void delete(DeleteProgrammingTechnologiesReq deleteProgrammingTechnologiesRequest) {
		_programmingTechnologiesRepo.deleteById(deleteProgrammingTechnologiesRequest.getId());
		
	}
	@Override
	public void update(UpdateProgrammingTechnologiesReq updateProgrammingTechnologiesRequest) {
		ProgrammingTechnology programmingTechnology = _programmingTechnologiesRepo.findById(updateProgrammingTechnologiesRequest.getId()).get();
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepo.findById(updateProgrammingTechnologiesRequest.getProgrammingLanguageId()).get();
		
		programmingTechnology.setName(updateProgrammingTechnologiesRequest.getName());
		programmingTechnology.setProgrammingLanguage(programmingLanguage);
		_programmingTechnologiesRepo.save(programmingTechnology);

	}
	//-----business rules
	
	public void checkEmptyProgrammingTechnologyName(String name) throws Exception{
		if (name.isEmpty()) {
			 throw new Exception("cannot be empty");
		}
	}

}
