package com.example.demo.adapters.outbound;

import com.example.demo.domain.model.Transaction;
import com.example.demo.domain.port.TransactionRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class InMemoryTransactionRepository implements TransactionRepository {
    private Map<String, Transaction> db = new HashMap<>();

    @Override
    public List<Transaction> listAll(){
        return db.values().stream().toList();
    }

//    @Override
//    public List<Transaction> filter(Predicate<Transaction> filters){
//        List<Transaction> all = this.listAll();
//
//        return all.stream().filter(filters).toList();
//    }

    @Override
    public void save(Transaction transaction){
        db.put(transaction.getUuid(), transaction); //[ ] O lombok está funcionando ?
    }

}
