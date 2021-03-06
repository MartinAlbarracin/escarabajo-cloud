package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import play.data.format.Formats;

@Entity
@Table(name="recompensa_usuario")
public class RecompensaUsuario extends AppModel{

	@EmbeddedId
	public RecompensaUsuarioPK recompensaUsuarioPK;
	
	@ManyToOne
	@JoinColumn(name = "id_recompensa", referencedColumnName = "id")
	public Recompensa recompensa;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", referencedColumnName = "id")
	public User usuario;
	
	@Formats.DateTime(pattern = "dd-MM-yyyy")
	@Column(name="fecha", nullable=false)
	public Date fecha;
	
	public static AppModel.Finder<RecompensaUsuarioPK, RecompensaUsuario> find;

	public RecompensaUsuario() {
		super();
		find = new AppModel.Finder<RecompensaUsuarioPK, RecompensaUsuario> (RecompensaUsuario.class);
		this.recompensaUsuarioPK = new RecompensaUsuarioPK();
		this.fecha = new Date();
	}
/*
	public RecompensaUsuario(RecompensaUsuarioPK recompensaUsuarioPK, Date fecha) {
		super();
		find = new AppModel.Finder<RecompensaUsuarioPK, RecompensaUsuario> (RecompensaUsuario.class);
		this.recompensaUsuarioPK = new RecompensaUsuarioPK();
		this.fecha = fecha;
	}*/
	
}
