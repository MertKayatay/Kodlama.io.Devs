package kodlama.io.Kodlama.io.Devs.business.requests.programmingTechnologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UpdateProgrammingTechnologiesReq {
	private int id;
	private String name;
	private int programmingLanguageId;

}
