package com.Junit_Mokito.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Junit_Mokito.Entity.UsersEntity;





@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Integer> {
	
	


}
