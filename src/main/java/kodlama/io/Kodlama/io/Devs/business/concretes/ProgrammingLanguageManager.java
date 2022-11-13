package kodlama.io.Kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Kodlama.io.Devs.business.abstracts.IProgrammingLanguageService;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.CreateProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.DeleteProgrammingLanguageReq;
import kodlama.io.Kodlama.io.Devs.business.requests.programmingLanguage.UpdateProgrammingReq;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesResponse;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetAllProgrammingLanguagesWithTechnologies;
import kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingLanguage.GetByIdProgrammingLanguageResponse;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.Kodlama.io.Devs.dataAccess.abstracts.ProgrammingTechnologiesRepository;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingLanguage;
import kodlama.io.Kodlama.io.Devs.entities.concretes.ProgrammingTechnology;

@Service
public class ProgrammingLanguageManager implements IProgrammingLanguageService {
    private ProgrammingLanguageRepository _programmingLanguageRepo;
    private ProgrammingTechnologiesRepository _programmingTechnologiesRepo;
	
    @Autowired
    public ProgrammingLanguageManager(ProgrammingLanguageRepository _programmingLanguageRepo, ProgrammingTechnologiesRepository _programmingTechnologiesRepo) {
		this._programmingLanguageRepo = _programmingLanguageRepo;
		this._programmingTechnologiesRepo = _programmingTechnologiesRepo;
	}
    
    public List<GetAllProgrammingLanguagesResponse> getAll(){
    	List<ProgrammingLanguage> programmingLanguages = _programmingLanguageRepo.findAll();
    	List<GetAllProgrammingLanguagesResponse> programmingLanguagesResponse = new ArrayList<>(); 
       for(ProgrammingLanguage programmingLanguage: programmingLanguages) {
    	   GetAllProgrammingLanguagesResponse responseItem = new GetAllProgrammingLanguagesResponse();
    	   responseItem.setId(programmingLanguage.getId());
    	   responseItem.setName(programmingLanguage.getName());
    	   programmingLanguagesResponse.add(responseItem);
       }
       return programmingLanguagesResponse;
    }
     
     public List<GetAllProgrammingLanguagesWithTechnologies>getAllWithProgrammingTechnologies(){
    	 List<ProgrammingLanguage> programmingLanguages = _programmingLanguageRepo.findAll();
    	 List<ProgrammingTechnology> programmingTechnologies = _programmingTechnologiesRepo.findAll();
    	 List<GetAllProgrammingLanguagesWithTechnologies> programmingLanguagesWithTechnologies =new ArrayList<GetAllProgrammingLanguagesWithTechnologies>();
    	 
    	 for(ProgrammingLanguage programmingLanguage: programmingLanguages) {
    		 GetAllProgrammingLanguagesWithTechnologies responseItem = new GetAllProgrammingLanguagesWithTechnologies();
    		 responseItem.setName(programmingLanguage.getName());
    		 responseItem.setId(programmingLanguage.getId());
    		 programmingLanguagesWithTechnologies.add(responseItem);
    	 }
    	 return programmingLanguagesWithTechnologies;

     }
     
      public GetByIdProgrammingLanguageResponse getById(int id){
    	  ProgrammingLanguage programmingLanguage = _programmingLanguageRepo.findById(id).get();
    	  GetByIdProgrammingLanguageResponse responseItem =new GetByIdProgrammingLanguageResponse();
    	  responseItem.setId(programmingLanguage.getId());
    	  responseItem.setName(programmingLanguage.getName());
    	  
    	  
    	  return responseItem;
    	  
      }

	@Override
	public void add(CreateProgrammingLanguageReq createProgrammingLanguageReq) {
		ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
		programmingLanguage.setName(createProgrammingLanguageReq.getName());
		_programmingLanguageRepo.save(programmingLanguage);

	}

	@Override
	public void delete(DeleteProgrammingLanguageReq deleteProgrammingLanguageReq) {
		_programmingLanguageRepo.deleteById(deleteProgrammingLanguageReq.getId());
		
		
	}

	@Override
	public void update(UpdateProgrammingReq updateProgrammingLanguageReq) {
		ProgrammingLanguage programmingLanguage = _programmingLanguageRepo.findById(updateProgrammingLanguageReq.getId()).get();
		programmingLanguage.setName(updateProgrammingLanguageReq.getName());
		_programmingLanguageRepo.save(programmingLanguage);
		
		
	}
	//------business rule
	public void checkEmptyProgrammingLanguageName(String name) throws Exception{
		if (name.isEmpty()) {
			 throw new Exception("cannot be empty");
		}
	}
	
}

	
    
    
    
    
    
    
    
    
    
    
    
   

	
	
