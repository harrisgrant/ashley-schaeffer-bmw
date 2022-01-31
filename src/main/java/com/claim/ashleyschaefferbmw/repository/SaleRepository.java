package com.claim.ashleyschaefferbmw.repository;

import com.claim.ashleyschaefferbmw.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Integer> {

    List<Sale> findAll();

    Sale findSaleByInvoiceNum(Integer invoiceNum);


}
