package dev.java10x.Ticket.atendente;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteService {

    private final AtendenteRepository atendenteRepository;

    public AtendenteService(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    public AtendenteModel criarAtendente(AtendenteModel atendenteModel) {
        return atendenteRepository.save(atendenteModel);

    }

    public List<AtendenteModel> listarTodosAtendentes() {
        return atendenteRepository.findAll();
    }

    public AtendenteModel buscarAtendentePorId(Long id){
        return atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente nao encontrado"));
    }
}
