package br.com.noe.hydra.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
public enum Bank {

    POKEMONS_BANK("Banco Pokemon", 1),
    DIGIMONS_BANK("Banco Digimon", 2),
    GREMIOS_BANK("BANCO GREMIO", 3);

    private final String bankName;
    private final Integer bankCode;

}
