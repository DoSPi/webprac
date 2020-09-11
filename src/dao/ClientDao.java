package dao;

import entity.Client;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Transactional
@Repository
public class ClientDao extends Dao<Client>{
}
