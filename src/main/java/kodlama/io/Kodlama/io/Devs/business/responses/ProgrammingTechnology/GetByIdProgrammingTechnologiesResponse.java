package kodlama.io.Kodlama.io.Devs.business.responses.ProgrammingTechnology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdProgrammingTechnologiesResponse {
	private int id;
	private String name;
	private String prgorammingLanguageName;

}
