import play.sports.*

class HomeController {

  def index() {
  	def catNacional = Categoria.findByNombre("FÚTBOL NACIONAL")
	def noticiasNacionales = Noticia.findAllByCategoria(catNacional, [max: 3, sort: "fechaPublicacion", order: "desc"])  

	def catInternacional = Categoria.findByNombre("FÚTBOL INTERNACIONAL")
	def noticiasInternacionales = Noticia.findAllByCategoria(catInternacional, [max: 3, sort: "fechaPublicacion", order: "desc"])  

	def catMundial = Categoria.findByNombre("MUNDIAL")
	def noticiasMundial = Noticia.findAllByCategoria(catMundial, [max: 3, sort: "fechaPublicacion", order: "desc"])  

	def catSeleccion = Categoria.findByNombre("SELECCIÓN MEXICANA")
	def noticiasSeleccion= Noticia.findAllByCategoria(catSeleccion, [max: 3, sort: "fechaPublicacion", order: "desc"])  

	
	[noticiasNacionales: noticiasNacionales, noticiasInternacionales: noticiasInternacionales, noticiasMundial: noticiasMundial, noticiasSeleccion: noticiasSeleccion]
  }// End of method

}// End of class
