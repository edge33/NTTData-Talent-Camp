package com.nttdata.talentcamp.università;

public enum RuoloDocenti {

	RICERCATORE, A_CONTRATTO, A_TEMPO_INDETERMINATO;
	
	

public String toString() {
	switch(this) {
	case RICERCATORE:
	return "RICERCATORE";
	case A_CONTRATTO:
		return "A_CONTRATTO";
	case A_TEMPO_INDETERMINATO:
		return "A_TEMPO_INDETERMINATO";
		default:
			return "";
	}
}	
	
	
	}	


/*
 * La classeEnumOgni tipo enumerativo `e una classe che estende la classe genericaEnum<E extends Enum<E>>(java.lang)
 * Metodi definiti inEnum
 * public String name()
 * public int ordinal()
 * public int compareTo(E o)
 * Confronta l’oggetto di tipo 
 * enumerativo che esegue il metodo conquello fornito come argomento. Restituisce un valore negativo, zero oun valore 
 * positivo a seconda che l’oggetto che esegue il metodopreceda, sia uguale o segua quello fornito come argomento, 
 * sulla basedell’ordine in cui sono dichiarate le costanti nel tipo enumerativo.Il metodocompareTo`efinale 
 * dunque non pu`o essere sovrascritto
 * 
 * public static E[] values()
 * Restituisce l’array array contenente le costanti del tipo enumerativonell’ordine in cui sono dichiarate.*/
