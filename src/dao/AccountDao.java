package dao;
import entity.Account;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class AccountDao extends Dao<Account>{
}
