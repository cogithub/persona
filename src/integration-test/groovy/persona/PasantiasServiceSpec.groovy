package persona

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PasantiasServiceSpec extends Specification {

    PasantiasService pasantiasService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Pasantias(...).save(flush: true, failOnError: true)
        //new Pasantias(...).save(flush: true, failOnError: true)
        //Pasantias pasantias = new Pasantias(...).save(flush: true, failOnError: true)
        //new Pasantias(...).save(flush: true, failOnError: true)
        //new Pasantias(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //pasantias.id
    }

    void "test get"() {
        setupData()

        expect:
        pasantiasService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Pasantias> pasantiasList = pasantiasService.list(max: 2, offset: 2)

        then:
        pasantiasList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        pasantiasService.count() == 5
    }

    void "test delete"() {
        Long pasantiasId = setupData()

        expect:
        pasantiasService.count() == 5

        when:
        pasantiasService.delete(pasantiasId)
        sessionFactory.currentSession.flush()

        then:
        pasantiasService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Pasantias pasantias = new Pasantias()
        pasantiasService.save(pasantias)

        then:
        pasantias.id != null
    }
}
