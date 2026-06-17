package almixarifado.model;

import almixarifado.model.enums.StatusReservaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reserva_estoque")
@AllArgsConstructor
@NoArgsConstructor
public class ReservaEstoque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long pedidoId;
    private Long produtoId;
    private Integer quantidade;
    @Enumerated(EnumType.STRING)
    private StatusReservaEnum status; // RESERVADO, SEPARADO, EXPEDIDO
    @Embedded
    private LocalizacaoFisica localizacao;
}
