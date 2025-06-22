package persona

import grails.gorm.services.Service

@Service(Pasantias)
interface PasantiasService {

    Pasantias get(Serializable id)

    List<Pasantias> list(Map args)

    Long count()

    void delete(Serializable id)

    Pasantias save(Pasantias pasantias)

}