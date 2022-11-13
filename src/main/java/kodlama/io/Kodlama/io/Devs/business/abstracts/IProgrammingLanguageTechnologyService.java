package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.CreateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.DeleteProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies.UpdateProgrammingTechnologiesReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetAllProgrammingLanguageTechnologiesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology.GetByIdProgrammingTechnologiesResponse;

public interface IProgrammingLanguageTechnologyService {
	
	List<GetAllProgrammingLanguageTechnologiesResponse> getAll();
	
	GetByIdProgrammingTechnologiesResponse getById(int id);
	
	void add(CreateProgrammingTechnologiesReq createProgrammingTechnologiesRequest);
	void delete(DeleteProgrammingTechnologiesReq deleteProgrammingTechnologiesRequest);
	void update(UpdateProgrammingTechnologiesReq updateProgrammingTechnologiesRequest);

	
	
	
}
