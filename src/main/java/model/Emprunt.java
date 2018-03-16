/**
 * 
 */
package model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author GOBERT Guillaume
 *
 */
@Entity
@Table(name = "EMPRUNT")
public class Emprunt {

	@Id
	private Integer id;
	@Column(name = "DATE_DEBUT")
	@Temporal(TemporalType.DATE)
	private Date dateDebut;
	@Column(name = "DATE_FIN")
	@Temporal(TemporalType.DATE)
	private Date dateFin;
	@Column(name = "DELAI")
	private Integer delai;
	@ManyToMany(mappedBy = "emprunts")
	private List<Livre> livres;
	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	private Client client;

	/**
	 * Getter
	 * 
	 * @return the livres
	 */
	public List<Livre> getLivres() {
		return livres;
	}

	/**
	 * Setter
	 * 
	 * @param livres
	 *            the livres to set
	 */
	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	/**
	 * Constructeur
	 *
	 */
	public Emprunt() {
		super();
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter
	 * 
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter
	 * 
	 * @return the dateDebut
	 */
	public Date getDateDebut() {
		return dateDebut;
	}

	/**
	 * Setter
	 * 
	 * @param dateDebut
	 *            the dateDebut to set
	 */
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Getter
	 * 
	 * @return the dateFin
	 */
	public Date getDateFin() {
		return dateFin;
	}

	/**
	 * Setter
	 * 
	 * @param dateFin
	 *            the dateFin to set
	 */
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * Getter
	 * 
	 * @return the delai
	 */
	public Integer getDelai() {
		return delai;
	}

	/**
	 * Setter
	 * 
	 * @param delai
	 *            the delai to set
	 */
	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	/**
	 * Getter
	 * 
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * Setter
	 * 
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
