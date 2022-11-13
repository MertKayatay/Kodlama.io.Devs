package kodlama.io.Kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;

public interface IProgrammingLanguageService {
	List<GetAllProgrammingLanguagesResponse> getAll();
	GetByIdProgrammingLanguageResponse getById(int id);
	
	void add(CreateProgrammingLanguageReq createProgrammingLanguageReq);
	
	void delete(DeleteProgrammingLanguageReq deleteProgrammingLanguageReq);
	
	void update(UpdateProgrammingReq updateProgrammingLanguageReq);

}
