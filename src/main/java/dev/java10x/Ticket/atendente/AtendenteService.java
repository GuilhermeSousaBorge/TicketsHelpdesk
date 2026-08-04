package dev.java10x.Ticket.atendente;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AtendenteService {

    private final AtendenteRepository atendenteRepository;
    private final AtendenteMapper atendenteMapper;

    public AtendenteService(AtendenteRepository atendenteRepository, AtendenteMapper atendenteMapper) {
        this.atendenteRepository = atendenteRepository;
        this.atendenteMapper = atendenteMapper;
    }

    public AtendenteDTO criarAtendente(AtendenteDTO atendenteDTO) {
        AtendenteModel atendente = atendenteMapper.map(atendenteDTO);
        atendente = atendenteRepository.save(atendente);
        return atendenteMapper.map(atendente);
    }

    public List<AtendenteDTO> listarTodosAtendentes() {
        return atendenteRepository.findAll().stream().map(atendenteMapper::map).toList();
    }

    public AtendenteDTO buscarAtendentePorId(Long id){
        AtendenteModel atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente nao encontrado"));
        return atendenteMapper.map(atendente);
    }

    public AtendenteDTO editarAtendente(Long id, AtendenteDTO atendenteDTO){
        AtendenteModel atendente = atendenteRepository.findById(id).orElseThrow(() -> new RuntimeException("Atendente nao encontrado"));
        atendente.setNome(atendenteDTO.getNome());
        atendente.setEmail(atendenteDTO.getEmail());
        atendente.setIdade(atendenteDTO.getIdade());
        atendente.setNivelSuporte(atendenteDTO.getNivelSuporte());
        atendente.setTicket(atendenteDTO.getTicket());
        atendente = atendenteRepository.save(atendente);
        return atendenteMapper.map(atendente);
    }

    public void apagarAtendente(Long id){
        atendenteRepository.deleteById(id);
    }
}
