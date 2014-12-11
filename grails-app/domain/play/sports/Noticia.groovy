package play.sports

class Noticia {
	String titulo
	Date fechaPublicacion = new Date()
	String redactor
	String contenido
	Categoria categoria
	String imagen

    static constraints = {
    	titulo  nullable: false, maxSize: 150
    	fechaPublicacion nullable: false
		redactor nullable: false, maxSize: 70
		contenido nullable: false, maxSize: 5000
		imagen nullable: false, url: true
		categoria nullable: false
    }

    String toString() {
    	titulo
    }
}
