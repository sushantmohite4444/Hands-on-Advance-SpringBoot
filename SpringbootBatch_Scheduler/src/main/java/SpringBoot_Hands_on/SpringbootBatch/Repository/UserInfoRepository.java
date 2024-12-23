package SpringBoot_Hands_on.SpringbootBatch.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringBoot_Hands_on.SpringbootBatch.Entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
	 
	
	

}
