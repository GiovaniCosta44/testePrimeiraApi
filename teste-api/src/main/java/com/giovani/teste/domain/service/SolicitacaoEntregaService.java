package com.giovani.teste.domain.service;

import com.giovani.teste.domain.exception.NegocioException;
import com.giovani.teste.domain.model.Cliente;
import com.giovani.teste.domain.model.Entrega;
import com.giovani.teste.domain.model.StatusEntrega;
import com.giovani.teste.domain.repository.ClienteRepository;
import com.giovani.teste.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return  entregaRepository.save(entrega);
    }


}
