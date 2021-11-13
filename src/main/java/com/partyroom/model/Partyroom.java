package com.partyroom.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * Esta clase repesenta a la  entidad Bote
 * @author desaextremo
 */

@Entity
@Table(name = "partyroom")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Partyroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Identificador del Bote
     */
    private Integer id;
    /**
     * Nombre del Bote
     */
    private String name;
    /**
     * Marca del Bote
     */
    private String owner;
    /**
     * Año o modelo del bote
     */
    private Integer capacity;
    /**
     * Descripción del bote
     */
    private String description;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    @JsonIgnoreProperties("partyrooms")
    /**
     * Categoria a la pertenece el Bote
     */
    private Category category;


    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom","client"})
    /**
     * Listado de mensajes asociados al Bote
     */
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "partyroom")
    @JsonIgnoreProperties({"partyroom","messages"})
    /**
     * Listado de reservas asociadas al Bote
     */
    public List<Reservation> reservations;

}
