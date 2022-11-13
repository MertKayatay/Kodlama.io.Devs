package kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateProgrammingTechnologiesReq {
	private String name;
	private int programmingLanguageId;

}
