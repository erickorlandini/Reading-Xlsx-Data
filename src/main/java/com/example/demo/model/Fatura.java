package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "faturas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fatura_po")
    private String faturaPo;

    @Column(name = "data_fatura")
    private LocalDate dataFatura;

    @Column(name = "pais_procedencia")
    private String paisProcedencia;

    @Column(name = "urf_despacho")
    private String urfDespacho;

    @Column(name = "urf_entrada")
    private String urfEntrada;

    @Column(name = "incoterm")
    private String incoterm;

    @Column(name = "moeda_mle")
    private String moedaMle;

    @Column(name = "valor_mle")
    private BigDecimal valorMle;

    @Column(name = "moeda_desconto")
    private String moedaDesconto;

    @Column(name = "valor_desconto")
    private BigDecimal valorDesconto;

    @Column(name = "moeda_despesas")
    private String moedaDespesas;

    @Column(name = "valor_despesas")
    private BigDecimal valorDespesas;

    @Column(name = "moeda_frete")
    private String moedaFrete;

    @Column(name = "valor_despesas_prepaid")
    private BigDecimal valorFretePrepaid;

    @Column(name = "valor_despesas_collect")
    private BigDecimal valorFreteCollect;

    @Column(name = "valor_frete_nacional")
    private BigDecimal valorFreteNacional;

    @Column(name = "moeda_seguro")
    private String moedaSeguro;

    @Column(name = "valor_seguro")
    private BigDecimal valorSeguro;

    @Column(name = "partnumber")
    private String partnumber;

    @Column(name = "apelido")
    private String apelido;

    @Column(name = "descricao_resumida")
    private String descricaoResumida;

    @Column(name = "unidade_medida")
    private String unidadeMedida;

    @Column(name = "ncm")
    private String ncm;

    @Column(name = "destaque_ncm")
    private String destaqueNcm;

    @Column(name = "naladi_sh")
    private String naladiSh;

    @Column(name = "naladi_ncca")
    private String naladiNcca;

    @Column(name = "aliquota_icms")
    private String aliquotaIcms;

    @Column(name = "quantidade")
    private String quantidade;

    @Column(name = "quantidade_estatistia")
    private String quantidadeEstatistica;

    @Column(name = "peso_liquido")
    private String pesoLiquido;

    @Column(name = "peso_liquido_unitario")
    private String pesoLiquidoUnitario;

    @Column(name = "peso_bruto")
    private String pesoBruto;

    @Column(name = "exportador")
    private String exportador;

    @Column(name = "fabricante")
    private String fabricante;

    @Column(name = "valor_unitario")
    private BigDecimal valorUnitario;

    @Column(name = "valor_total_moeda")
    private BigDecimal valorTotalMoeda;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "nve")
    private String nve;

    @Column(name = "descricao_nfe")
    private String descricaoNfe;

    @Column(name = "quebra_auxiliar")
    private String quebraAuxiliar;

    @Column(name = "especificacao")
    private String especificacao;

    @Column(name = "numero_ato_concessorio")
    private String numeroAtoConcessorio;

    @Column(name = "item_ato")
    private String itemAto;

    @Column(name = "marca")
    private String marca;

    @Column(name = "numero_serie")
    private String numeroSerie;

    @Column(name = "modelo")
    private String modelo;

    @Column(name = "ano_fabricacao")
    private String anoFabricao;

    @Column(name = "lote")
    private String lote;

    @Column(name = "data_validade")
    private String dataValidade;

    @Column(name = "necessita_li")
    private Boolean necessitaLi;

    @Column(name = "numero_fatura")
    private String numeroFatura;

    @Column(name = "item_fatura")
    private String itemFatura;

    @Column(name = "cfop")
    private String cfop;

    @Column(name = "gtin")
    private String gtin;

    @Column(name = "codigo_secundario")
    private String codigoSecundario;

    @Column(name = "auxiliar_invoice")
    private String auxiliarInvoice;

    @Column(name = "sequencia_invoice")
    private String sequenciaInvoice;

    @Column(name = "numero_pedido")
    private String numeroPedido;

    @Column(name = "sequencia_pedido")
    private String sequenciaPedido;

    @Column(name = "numero_ordem_compra")
    private String numeroOrdemCompra;

    @Column(name = "sequencia_ordem_compra")
    private String sequenciaOrdemCompra;

    @Column(name = "area")
    private String area;
}

