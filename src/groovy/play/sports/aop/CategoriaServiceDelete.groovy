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
class CategoriaServiceDelete {

    @Pointcut(
        value='execution(void play.sports.CategoriaService.delete(..)) && bean(categoriaService) && args(categoria)',
        argNames='categoria')
    public void delete( Categoria categoria ) {}

    @Before('delete(categoria)')
    void before( Categoria categoria ) {
        log.info( "Begins request:${categoria}" )
    }

    @AfterReturning(
        pointcut='delete(play.sports.Categoria)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='delete(play.sports.Categoria)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}