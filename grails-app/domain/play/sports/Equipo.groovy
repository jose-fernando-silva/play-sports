package play.sports

class Equipo {

	String nombre
	String logo
	Integer identificador
	Liga liga
    static constraints = {
    	nombre nullable: false
    	logo nullable: false
    	identificador nullable: false
    	liga nullable: false
    }

    String toString() {
    	nombre
    }
}
