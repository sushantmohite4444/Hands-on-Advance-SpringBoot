package SpringBoot_Hands_on.SpringbootBatch.BatchConfig;

import org.apache.catalina.User;
import org.springframework.batch.item.ItemProcessor;

import SpringBoot_Hands_on.SpringbootBatch.Entity.UserInfo;

public class ModifyData implements ItemProcessor<UserInfo, UserInfo> {

	@Override
	public UserInfo process(UserInfo item) throws Exception {
		
		item.setLastName(item.getLastName().toUpperCase());
		
		return item;
	}

}
