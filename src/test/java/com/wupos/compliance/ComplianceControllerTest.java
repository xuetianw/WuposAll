package com.wupos.compliance;

import com.wupos.compliance.controller.ComplianceController;
import com.wupos.compliance.model.Transaction;
import com.wupos.compliance.service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@WebMvcTest({ComplianceController.class})
class ComplianceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    //private ComplianceController complianceController;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        complianceController = new ComplianceController();
        complianceController.setTransactionService(transactionService);
    }

    @Test
    void testSendMoneyValidation_InvalidTransaction() {
        Transaction transaction = new Transaction();

        // we are returning true for anyLong because we are testing the isolated behavior of the response
        // rather than how the function will react to an invalid ID
        when(transactionService.validateTransaction(anyLong())).thenReturn(true);

        ResponseEntity<String> response = complianceController.sendMoneyValidation(transaction);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Invalid transaction ID", response.getBody());
    }

    @Test
    void testSendMoneyValidation_ValidTransaction() {
        Transaction transaction = new Transaction();

        when(transactionService.validateTransaction(anyLong())).thenReturn(false);
        when(transactionService.validateMonthlyLimitAmount(transaction)).thenReturn(false);
        when(transactionService.validateMonthlyLimitNumber(transaction)).thenReturn(false);

        ResponseEntity<String> response = complianceController.sendMoneyValidation(transaction);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Transaction successfully validated", response.getBody());
    }

    @Test
    void testGetAllTransactions() {
        // assert that the mock transactions are the same as the response body
        List<Transaction> transactions = when(transactionService.getAllTransactions()).thenReturn(transactions);

        ResponseEntity<List<Transaction>> response = complianceController.getAllTransactions();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(transactions, response.getBody());
    }

    @Test
    void testGetTransactionById_ValidId() {
        // using anyLong to isolate the behavior of a valid Id look up
        Transaction transaction = new Transaction();
        when(transactionService.getTransactionById(anyLong())).thenReturn(transaction);

        ResponseEntity<Transaction> response = complianceController.getTransactionById(anyLong());

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo(transaction);
    }

    @Test
    void testGetTransactionById_InvalidId() {
        when(transactionService.getTransactionById(anyLong())).thenReturn(null);

        // assuming we got an invalid ID of long type
        ResponseEntity<Transaction> response = complianceController.getTransactionById(anyLong());

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }

    @Test
    void testCreateTransaction_Success() {
        when(transactionService.createTransaction(any(Transaction.class))).thenReturn(true);

        ResponseEntity<String> response = complianceController.createTransaction(new Transaction());

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Transaction created successfully");
    }

    @Test
    void testCreateTransaction_Failure() {
        when(transactionService.createTransaction(any(Transaction.class))).thenReturn(false);

        ResponseEntity<String> response = complianceController.createTransaction(new Transaction());

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody()).isEqualTo("Failed to create transaction");
    }

    @Test
    void testProcessTransaction_Success() {
        TransactionRequest transactionRequest = new TransactionRequest();
        when(transactionService.processTransaction(transactionRequest)).thenReturn(true);

        ResponseEntity<String> response = complianceController.processTransaction(transactionRequest);

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Transaction processed successfully");
    }

    @Test
    void testProcessTransaction_Failure() {
        Transaction transactionRequest = new Transaction();
        when(transactionService.sendMoneyValidation(transactionRequest)).thenReturn(false);

        ResponseEntity<String> response = complianceController.processTransaction(transactionRequest);

        assertThat(response.getStatusCodeValue()).isEqualTo(400);
        assertThat(response.getBody()).isEqualTo("Failed to process transaction");
    }
}

    @Test
    void testUpdateTransaction_Success() {
        when(transactionService.updateTransaction(anyLong(), any(Transaction.class))).thenReturn(true);

        ResponseEntity<String> response = complianceController.updateTransaction(anyLong(), new Transaction());

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Transaction updated successfully");
    }

    @Test
    void testUpdateTransaction_Failure() {
        when(transactionService.updateTransaction(anyLong(), any(Transaction.class))).thenReturn(false);

        ResponseEntity<String> response = complianceController.updateTransaction(anyLong(), new Transaction());

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }

    @Test
    void testDeleteTransaction_Success() {
        when(transactionService.deleteTransaction(anyLong())).thenReturn(true);

        ResponseEntity<String> response = complianceController.deleteTransaction(anyLong());

        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isEqualTo("Transaction deleted successfully");
    }

    @Test
    void testDeleteTransaction_Failure() {
        when(transactionService.deleteTransaction(anyLong())).thenReturn(false);

        ResponseEntity<String> response = complianceController.deleteTransaction(anyLong());

        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        assertThat(response.getBody()).isNull();
    }
}