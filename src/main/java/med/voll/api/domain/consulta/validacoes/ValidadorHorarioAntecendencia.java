package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecendencia implements ValidadorAgendamentoDeConsultas {

    public void validar(DadosAgendamentoConsulta dados) {
        LocalDateTime dataConsulta = dados.data();

        LocalDateTime agora = LocalDateTime.now();

        Long diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("Consulta deve ser agendada com antecendencia minima de 30 minutos");
        }
    }
}
