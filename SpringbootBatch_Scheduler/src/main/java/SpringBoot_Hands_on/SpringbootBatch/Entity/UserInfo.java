package SpringBoot_Hands_on.SpringbootBatch.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	@Id
	private String id ;
	private String name;
	private String lastName;
	

}
