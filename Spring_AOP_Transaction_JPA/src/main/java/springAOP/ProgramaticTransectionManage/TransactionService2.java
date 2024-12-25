package springAOP.ProgramaticTransectionManage;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import springAOP.Dao.DaoInterfaceJPA;
import springAOP.Entity.Student;

@Service
public class TransactionService2 {

  
    
    @Autowired 
    private TransactionTemplate transactionTemplate;

    @Autowired
    private DaoInterfaceJPA daoInterfaceJPA; 

    public void createUserWithTransaction( Student student) {
    	
    	TransactionCallback<TransactionStatus> transacton =  (TransactionStatus ts)->
    	{
    		
    		daoInterfaceJPA.save(student);
    		
    		return ts;
    	};
    	
    	  transactionTemplate.execute(transacton);
          
    	
    }
}
