package es.logixs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import es.logixs.domain.Products;
import es.logixs.domain.Requests;
import es.logixs.domain.Sales;
import es.logixs.repository.ProductsRepository;
import es.logixs.repository.RequestsRepository;
import es.logixs.repository.SalesRepository;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SalesProductsRequestsServiceTest {
    
    @Mock
    private SalesRepository salesRepositoryMock;
    @Mock
    private ProductsRepository productsRepositoryMock;
    @Mock
    private RequestsRepository requestsRepositoryMock;
    @InjectMocks
    private SalesProductsRequestsService salesProductsRequestsService;

    @Test
    public void deleteSalesTest() {
        Sales sale = new Sales("0001","0001","0001","1A","1","1",true);
        
        salesProductsRequestsService.deleteSales(sale);

        verify(salesRepositoryMock, times(1)).delete(sale);
    }

  
    @Test
    public void insertSalesTest() {
        Sales sales = mock(Sales.class);

        List<Sales> salesList = List.of(sales, sales, sales);
        List<Sales> insertedSalesList = salesProductsRequestsService.insertSalesList(salesList);

        verify(salesRepositoryMock, times(3)).insert(any(Sales.class));
        
        assertIterableEquals(salesList, insertedSalesList);
    }

  

    @Test
    public void findAllSalesTest() {
        Sales sale1 = new Sales("0001","0001","0001","1A","1","1",true);
        Sales sale2 = new Sales("0002","0002","0002","2A","2","2",false);

        List<Sales> salesListMock = Arrays.asList(sale1,sale2);
        when(salesRepositoryMock.findAll()).thenReturn(salesListMock);

        List<Sales> resultSalesList = salesProductsRequestsService.findAllSales();

        verify(salesRepositoryMock, times(1)).findAll();
        assertEquals(salesListMock,resultSalesList);

    }

    // Products
    @Test
    public void insertProductsTest() {
        Products products = mock(Products.class);

        List<Products> productsList = List.of(products, products, products);
        List<Products> insertedproductsList = salesProductsRequestsService.insertProductsList(productsList);

        verify(productsRepositoryMock, times(3)).insert(any(Products.class));
        
        assertIterableEquals(productsList, insertedproductsList);
    }

    @Test
    public void deleteProductTest() {
        Products product = new Products("7", "23", "123456789", "company1", "scientificName1", "product1", "category1", "ES", "quality1", "description1");
        
        salesProductsRequestsService.deleteProducts(product.getId());

        verify(productsRepositoryMock, times(1)).delete(product.getId());
    }

    // Requests
    @Test
    public void insertRequestsTest() {
        Requests request = mock(Requests.class);

        List<Requests> requestsList = List.of(request, request, request);
        List<Requests> insertedRequestsList = salesProductsRequestsService.insertRequestsList(requestsList);

        verify(requestsRepositoryMock, times(3)).insert(any(Requests.class));
        
        assertIterableEquals(requestsList, insertedRequestsList);
    }

    @Test
    public void deleteRequestsTest() {
        Requests request = new Requests("123456789", "offer6", "owner6", "company6");
        
        salesProductsRequestsService.deleteRequests(request.getId());

        verify(requestsRepositoryMock, times(1)).delete(request.getId());
    }
} 
