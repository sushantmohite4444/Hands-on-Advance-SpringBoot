package springAOP.ProgramaticTransectionManage;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import springAOP.Dao.DaoInterfaceJPA;
import springAOP.Entity.Student;

@Service
public class TransactionService1 {

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Autowired
    private DaoInterfaceJPA daoInterfaceJPA; 

    public void createUserWithTransaction( Student student) {
        // Create a new transaction definition
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        def.setIsolationLevel(DefaultTransactionDefinition.ISOLATION_READ_COMMITTED);
        def.setPropagationBehavior(DefaultTransactionDefinition.PROPAGATION_REQUIRED);

        // Start a new transaction
        TransactionStatus status = transactionManager.getTransaction(def);
        try {
            // Perform some actions within the transaction
        	daoInterfaceJPA.save(student);

            // Commit the transaction if everything goes well
            transactionManager.commit(status);
        } catch (Exception e) {
            // If an exception occurs, rollback the transaction
            transactionManager.rollback(status);
            throw new RuntimeException("Transaction failed, rolled back", e);
        }
    }
}
