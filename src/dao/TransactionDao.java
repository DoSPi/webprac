package dao;
import entity.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class TransactionDao extends Dao<Transaction>{
    }