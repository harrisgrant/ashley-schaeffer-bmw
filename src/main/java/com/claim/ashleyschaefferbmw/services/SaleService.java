package com.claim.ashleyschaefferbmw.services;

import com.claim.ashleyschaefferbmw.entity.Sale;
import com.claim.ashleyschaefferbmw.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;


    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }


    public Sale findSaleByInvoiceNum(Integer invoiceNum) {
        return saleRepository.findSaleByInvoiceNum(invoiceNum);
    }


    public Sale addSale(Sale sale) {
        Sale newSale = new Sale(sale.getInvoiceNum(), sale.getCustomer(), sale.getVehicle());
        return saleRepository.save(newSale);
    }


    public Sale updateSale(Sale sale, Integer invoiceNum) {
        Sale updateSale = saleRepository.findSaleByInvoiceNum(invoiceNum);
        if (sale == null) { return null; }
        sale.setInvoiceNum(sale.getInvoiceNum());
        sale.setCustomer(sale.getCustomer());
        sale.setVehicle(sale.getVehicle());
        return saleRepository.save(updateSale);
    }


    public Boolean deleteSale(Integer invoiceNum) {
        Sale sale = saleRepository.findSaleByInvoiceNum(invoiceNum);
        if (sale != null) { saleRepository.delete(sale); }
        return true;
    }
}

