package dev.java10x.Ticket.atendente;

import org.springframework.stereotype.Component;

@Component
public class AtendenteMapper {

    public AtendenteModel map(AtendenteDTO atendenteDTO){
        return new AtendenteModel(
            atendenteDTO.getId(),
            atendenteDTO.getNome(),
            atendenteDTO.getIdade(),
            atendenteDTO.getEmail(),
            atendenteDTO.getNivelSuporte(),
            atendenteDTO.getTicket()
        );
    }

    public AtendenteDTO map(AtendenteModel atendenteModel){
        return new AtendenteDTO(
            atendenteModel.getId(),
            atendenteModel.getNome(),
            atendenteModel.getIdade(),
            atendenteModel.getEmail(),
            atendenteModel.getNivelSuporte(),
            atendenteModel.getTicket()
        );
    }
}
