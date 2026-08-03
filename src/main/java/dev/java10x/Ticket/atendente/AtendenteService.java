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

    public AtendenteModel editarAtendente(Long id, AtendenteModel novoAtendente){
        AtendenteModel atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente nao encontrado"));
        atendente.setNome(novoAtendente.getNome());
        atendente.setEmail(novoAtendente.getEmail());
        atendente.setIdade(novoAtendente.getIdade());
        atendente.setNivelSuporte(novoAtendente.getNivelSuporte());
        atendente.setTicket(novoAtendente.getTicket());
        return atendenteRepository.save(atendente);
    }

    public void apagarAtendente(Long id){
        atendenteRepository.deleteById(id);
    }
}
