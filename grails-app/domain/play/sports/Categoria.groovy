package play.sports

class Categoria {
	String nombre
	String descripcion

    static constraints = {
    	nombre nullable: false, maxSize: 50
    	descripcion nullable: false, maxSize: 255
    }

    String toString() {
    	nombre
    }
}
