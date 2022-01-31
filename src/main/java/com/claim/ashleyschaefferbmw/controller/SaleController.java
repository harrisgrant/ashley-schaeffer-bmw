package com.claim.ashleyschaefferbmw.controller;

import com.claim.ashleyschaefferbmw.entity.Sale;
import com.claim.ashleyschaefferbmw.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping("/sales")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/sales/{invoiceNum}")
    public Sale findSaleByInvoiceNum(@PathVariable Integer invoiceNum) {
        return saleService.findSaleByInvoiceNum(invoiceNum);
    }

    @PostMapping("/sales")
    public Sale addSale(@RequestBody Sale sale) {
        return saleService.addSale(sale);
    }

    @PutMapping("/sales/{invoiceNum}")
    public Sale updateSale(@RequestBody Sale sale, @PathVariable Integer invoiceNum) {
        return saleService.updateSale(sale, invoiceNum);
    }

    @DeleteMapping("/sales/{invoiceNum}")
    public Boolean deleteSale(@PathVariable Integer invoiceNum) {
        return saleService.deleteSale(invoiceNum);
    }
}
