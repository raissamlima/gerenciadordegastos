package com.example.demo.adapters.inbound;

import com.example.demo.adapters.inbound.dto.TransferRequest;
import com.example.demo.adapters.inbound.dto.TransferResponse;
import com.example.demo.usecase.TransferMoneyUseCase;
import com.example.demo.usecase.TransferResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Adapter de entrada (HTTP)
 * Faz a ponte entre o mundo externo e a aplicação
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final TransferMoneyUseCase useCase;

    public PaymentController(TransferMoneyUseCase useCase) {
        this.useCase = useCase;
    }

    /**
     * Endpoint para transferência (tipo Pix)
     */
    @PostMapping("/transfer")
    public TransferResponse transfer(@RequestBody TransferRequest request) {

        // chama o caso de uso
        TransferResult result = useCase.execute(
                request.getSenderId(),
                request.getReceiverId(),
                request.getAmount()
        );

        // converte para resposta da API
        return new TransferResponse(
                result.getTransactionId(),
                result.getStatus(),
                result.getAmount(),
                result.getSenderName(),
                result.getSenderCpf(),
                result.getReceiverName(),
                result.getReceiverCpf(),
                result.getTimestamp()
        );
    }
}
