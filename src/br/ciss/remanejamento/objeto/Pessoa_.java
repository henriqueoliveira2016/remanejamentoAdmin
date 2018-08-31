package br.ciss.remanejamento.objeto;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

import br.ciss.remanejamento.objeto.Pessoa;

@Generated(value="Dali", date="2016-05-24T21:40:15.830-0300")
@StaticMetamodel(Pessoa.class)
public class Pessoa_ {
	
	public static volatile SingularAttribute<Pessoa, Long> idPessoa;
	public static volatile SingularAttribute<Pessoa, String> dataNascimento;
	public static volatile SingularAttribute<Pessoa, String> nome;
	public static volatile SingularAttribute<Pessoa, String> email;
	public static volatile ListAttribute<Pessoa, String> sexo;

}
