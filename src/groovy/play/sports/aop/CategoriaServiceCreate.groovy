package play.sports.aop

import play.sports.Categoria

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class CategoriaServiceCreate {

    @Pointcut(
        value='execution(void play.sports.CategoriaService.create(..)) && bean(categoriaService) && args(categoria)',
        argNames='categoria')
    public void create( Categoria categoria ) {}

    @Before('create(categoria)')
    void before( Categoria categoria ) {
        log.info( "Begins request: ${categoria}" )
    }

    @AfterReturning(
        pointcut='create(play.sports.Categoria)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='create(play.sports.Categoria)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}